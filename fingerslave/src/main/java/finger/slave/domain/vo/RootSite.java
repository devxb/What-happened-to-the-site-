package finger.slave.domain.vo;

import java.util.*;
import java.time.LocalDate;

public class RootSite implements Site{
	
	private final String uri;
	private final Integer contentLength;
	private final LocalDate updatedDate;
	private List<Site> relationSites;
	private List<Keyword> keywords;
	private final StringBuffer siteInfoBuffer;
	
	@Override
	public String getSiteInfo(){
		if(this.isInfoEmpty()) this.buildSiteInfo();
		return this.siteInfoBuffer.toString();
	}
	
	private boolean isInfoEmpty(){
		return this.siteInfoBuffer.length() == 0;
	}
	
	private void buildSiteInfo(){
		this.siteInfoBuffer.append("URI : ").append(this.uri)
			.append(" ContentLength : ").append(this.contentLength)
			.append(" Updated at : ").append(this.updatedDate);
		this.buildKeywordInfo();
		this.buildRelationSiteInfo();
	}
	
	private void buildKeywordInfo(){
		this.siteInfoBuffer.append(" Keywords : ");
		for(Keyword keyword : this.keywords)
			this.siteInfoBuffer.append("(")
			.append(keyword.getWord())
			.append(" : ")
			.append(keyword.getCount())
			.append(") ");
	}
	
	private void buildRelationSiteInfo(){
		this.siteInfoBuffer.append(" RelationSites : ");
		for(Site site : this.relationSites)
			this.siteInfoBuffer.append("\n")
				.append(site.getSiteInfo());
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
		this.siteInfoBuffer = new StringBuffer();
	}
	
	public static class RootSiteBuilder extends SiteBuilder<RootSite>{
		
		@Override
		public RootSite build(){
			return new RootSite(this);
		}
		
	}
	
}