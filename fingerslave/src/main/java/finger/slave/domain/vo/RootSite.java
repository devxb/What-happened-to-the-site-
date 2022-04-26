package finger.slave.domain.vo;

import java.util.*;
import java.time.LocalDate;

public class RootSite implements Site{
	
	private final String uri;
	private final Integer contentLength;
	private final LocalDate updatedDate;
	private List<Site> relationSites;
	private List<Keyword> keywords;
	
	@Override 
	public String getUri(){
		return this.uri;
	}
	
	@Override
	public Integer getContentLength(){
		return this.contentLength;
	}
	
	@Override 
	public LocalDate getUpdatedDate(){
		return this.updatedDate;
	}
	
	@Override 
	public List<Site> getRelationSites(){
		return this.relationSites;
	}
	
	@Override 
	public Site getRelaitonSite(String uri){
		for(Site site : this.relationSites) if(site.getUri().equals(uri)) return site;
		return null;
	}
	
	@Override 
	public List<Keyword> getKeywords(){
		return this.keywords;
	}
	
	@Override 
	public Keyword getKeyword(String word){
		for(Keyword keyword : this.keywords)
			if(keyword.getWord().equals(word)) return keyword;
		return null;
	}
	
	@Override
	public void addRelationSite(Site site){
		this.relationSites.add(site);
	}
	
	@Override
	public void addRelationSites(List<Site> sites){
		this.relationSites = sites;
	}
	
	@Override
	public void addKeyword(Keyword keyword){
		this.keywords.add(keyword);
	}
	
	@Override
	public void addKeywords(List<Keyword> keywords){
		this.keywords = keywords;
	}
	
	
	private RootSite(){
		this(null);
	}
	
	private RootSite(RootSiteBuilder builder){
		this.uri = builder.uri;
		this.contentLength = builder.contentLength;
		this.updatedDate = builder.updatedDate;
		this.keywords = new ArrayList<Keyword>();
		this.relationSites = new ArrayList<Site>();
	}
	
	public static class RootSiteBuilder extends SiteBuilder<RootSite>{
		
		@Override
		public RootSite build(){
			return new RootSite(this);
		}
		
	}
	
}