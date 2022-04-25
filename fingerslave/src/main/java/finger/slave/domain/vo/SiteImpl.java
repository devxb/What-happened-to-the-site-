package finger.slave.domain.vo;

import java.util.*;
import java.time.LocalDate;

public class SiteImpl implements Site{
	
	private final String uri;
	private final Integer contentLength;
	private final LocalDate updatedDate;
	private List<Site> relationSites;
	private final List<Keyword> keywords;
	
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
	public void setRelationSite(Site site){
		if(this.relationSites == null) this.relationSites = new ArrayList<Site>();
		this.relationSites.add(site);
	}
	
	@Override
	public void setRelationSites(List<Site> sites){
		this.relationSites = sites;
	}
	
	private SiteImpl(SiteImplBuilder builder){
		this.uri = builder.uri;
		this.contentLength = builder.contentLength;
		this.updatedDate = builder.updatedDate;
		this.keywords = builder.keywords;
		this.relationSites = new ArrayList<Site>();
	}
	
	public static class SiteImplBuilder extends SiteBuilder<SiteImpl>{
		
		private String uri;
		private Integer contentLength;
		private LocalDate updatedDate;
		private List<Keyword> keywords;
		
		@Override
		public SiteBuilder<SiteImpl> uri(String uri){
			this.uri = uri;
			return this;
		}
		
		@Override
		public SiteBuilder<SiteImpl> contentLength(Integer contentLength){
			this.contentLength = contentLength;
			return this;
		}
		
		@Override
		public SiteBuilder<SiteImpl> updatedDate(LocalDate updatedDate){
			this.updatedDate = updatedDate;
			return this;
		}
		
		@Override
		public SiteBuilder<SiteImpl> keywords(List<Keyword> keywords){
			this.keywords = keywords;
			return this;
		}
		
		@Override
		public SiteBuilder<SiteImpl> keyword(Keyword keyword){
			if(this.keywords == null) this.keywords = new ArrayList<Keyword>();
			this.keywords.add(keyword);
			return this;
		}
		
		@Override
		public SiteImpl build(){
			return new SiteImpl(this);
		}
		
	}
	
}