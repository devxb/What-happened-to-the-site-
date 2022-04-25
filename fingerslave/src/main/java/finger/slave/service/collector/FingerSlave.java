package finger.slave.service.collector;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;

import finger.slave.domain.vo.*;
import finger.slave.service.util.*;
import finger.slave.service.collector.crawler.FingerCrawler;
import finger.slave.service.parser.FingerParser;

import java.util.*;
import java.time.LocalDate;

@Service
public class FingerSlave{
	
	private final FingerCrawler htmlFingerCrawler;
	private final FingerParser<String> hyperLinkParser;
	private final FingerParser<Integer> keywordParser;
	private final RecursionDepth recursionDepth;
	private final List<String> ignorePatterns;
	
	public Site work(String uri){
		PriorityQueue<URIDepth> uriDepths = new PriorityQueue<URIDepth>();
		uriDepths.add(new URIDepth(uri, 0, this.rootSite()));
		Set<String> visitedURIs = new HashSet<String>();
		Site site = this.doWork(uriDepths, visitedURIs);
		return site;
	}
	
	private Site rootSite(){
		return new SiteImpl.SiteImplBuilder()
			.uri("root")
			.updatedDate(LocalDate.now())
			.build();
	}
	
	private Site doWork(PriorityQueue<URIDepth> uriDepths, Set<String> visitedURIs){
		Site rootSite = uriDepths.peek().parentSite;
		while(!uriDepths.isEmpty()){
			URIDepth nowURIDepth = uriDepths.poll();
			if(visitedURIs.contains(nowURIDepth.uri) || nowURIDepth.isOverDepth(this.recursionDepth.depth())) continue;
			visitedURIs.add(nowURIDepth.uri);
			
			String htmlContent = this.htmlFingerCrawler.crawl(nowURIDepth.uri);
			Site nextParentSite = this.makeSite(nowURIDepth.parentSite, nowURIDepth.uri, htmlContent);
			
			this.addNextURIDepths(htmlContent, nowURIDepth, uriDepths, nextParentSite);
		}
		return rootSite;
	}
	
	private Site makeSite(Site parentSite, String uri, String htmlContent){
		List<Keyword> nowKeywords = this.makeKeywords(htmlContent);
		Site site = new SiteImpl.SiteImplBuilder()
			.uri(uri)
			.contentLength(htmlContent.length())
			.updatedDate(LocalDate.now())
			.keywords(nowKeywords)
			.build();
		parentSite.setRelationSite(site);
		return site;
	}
	
	private List<Keyword> makeKeywords(String htmlContent){
		List<Keyword> keywords = new ArrayList<Keyword>();
		Map<String, Integer> keywordMap = this.keywordParser.parse(htmlContent, 
																   "채용", "가입", "recruit", "Join", "join", "인턴", "모집", "신청");
		for(Map.Entry<String, Integer> keywordEntry : keywordMap.entrySet()){
			Keyword keyword = new KeywordImpl.KeywordImplBuilder()
				.word(keywordEntry.getKey())
				.count(keywordEntry.getValue())
				.build();
			keywords.add(keyword);
		}
		return keywords;
	}
	
	private void addNextURIDepths(String htmlContent, URIDepth uriDepth, PriorityQueue<URIDepth> uriDepths, Site parentSite){
		Map<String, String> hyperLinkMap = this.hyperLinkParser.parse(htmlContent, uriDepth.uri);
		for(Map.Entry<String, String> hyperLinkEntry : hyperLinkMap.entrySet()) {
			if(this.isIgnoreUri(hyperLinkEntry.getValue())) continue;
			if(this.isDifferHost(uriDepth.uri, hyperLinkEntry.getValue())) 
				uriDepths.add(new URIDepth(hyperLinkEntry.getValue(), Math.max(this.recursionDepth.depth(), uriDepth.depth+1), parentSite));
			else uriDepths.add(new URIDepth(hyperLinkEntry.getValue(), uriDepth.depth+1, parentSite));
		}
	}
	
	private boolean isDifferHost(String standardUri, String targetUri){
		String starndardHost = URIExtractor.getHost(standardUri);
		String targetHost = URIExtractor.getHost(targetUri);
		return !starndardHost.equals(targetHost);
	}
	
	private boolean isIgnoreUri(String uri){
		for(String pattern : this.ignorePatterns)
			if(PatternCounter.count(uri, pattern) > 0) return true;
		return false;
	}
	
	@Autowired
	public FingerSlave(@Qualifier("HTMLFingerCrawler") FingerCrawler htmlFingerCrawler, 
					   @Qualifier("hyperLinkParser") FingerParser<String> hyperLinkParser, 
					   @Qualifier("keywordParser") FingerParser<Integer> keywordParser){
		this.htmlFingerCrawler = htmlFingerCrawler;
		this.hyperLinkParser = hyperLinkParser;
		this.keywordParser = keywordParser;
		this.recursionDepth = RecursionDepth.EASY;
		this.ignorePatterns = new ArrayList<String>();
		this.setIgnorePatterns();
	}
	
	private void setIgnorePatterns(){
		this.ignorePatterns.add("github");
		this.ignorePatterns.add("javascript");
		this.ignorePatterns.add("youtube");
		this.ignorePatterns.add("linkedin");
		this.ignorePatterns.add("facebook");
	}
	
	private static class URIDepth implements Comparable<URIDepth>{
		
		private Site parentSite;
		private String uri;
		private Integer depth;
		
		public URIDepth(String uri, Integer depth, Site parentSite){
			this.uri = this.convertUri(uri);
			this.depth = depth;
			this.parentSite = parentSite;
		}
		
		private String convertUri(String uri){
			uri = uri.trim();
			if(uri.charAt(uri.length()-1) == '/') uri = uri.substring(0, uri.length()-1);
			return uri;
		}
		
		@Override
		public int compareTo(URIDepth uriDepth){
			if(this.depth > uriDepth.getDepth()) return 1;
			if(this.depth < uriDepth.getDepth()) return -1;
			return 0;
		}
		
		int getDepth(){
			return this.depth;
		}
		
		private boolean isOverDepth(int celling){
			return this.depth > celling;
		}
		
	}
	
}