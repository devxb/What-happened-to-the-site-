package finger.slave.domain.vo;

import java.util.*;
import java.time.LocalDate;

public class LeafSite implements Site{
	
	private final String uri;
	private final Integer contentLength;
	private final LocalDate updatedDate;
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
		return null;
	}
	
	@Override 
	public Site getRelaitonSite(String uri){
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
		return;
	}
	
	@Override
	public void addRelationSites(List<Site> sites){
		return;
	}
	
	@Override
	public void addKeyword(Keyword keyword){
		this.keywords.add(keyword);
	}
	
	@Override
	public void addKeywords(List<Keyword> keywords){
		this.keywords = keywords;
	}
	
	private LeafSite(){
		this(null);
	}
	
	private LeafSite(LeafSiteBuilder builder){
		this.uri = builder.uri;
		this.contentLength = builder.contentLength;
		this.updatedDate = builder.updatedDate;
		this.keywords = new ArrayList<Keyword>();
	}
	
	public static class LeafSiteBuilder extends SiteBuilder<LeafSite>{
		
		@Override
		public LeafSite build(){
			return new LeafSite(this);
		}
		
	}
	
}