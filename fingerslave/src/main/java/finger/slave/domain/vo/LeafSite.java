package finger.slave.domain.vo;

import java.util.*;
import java.time.LocalDate;

public class LeafSite implements Site{
	
	private final String uri;
	private final Integer contentLength;
	private final LocalDate updatedDate;
	private List<Keyword> keywords;
	private StringBuffer siteInfoBuffer;
	
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
		this.siteInfoBuffer = new StringBuffer();
	}
	
	public static class LeafSiteBuilder extends SiteBuilder<LeafSite>{
		
		@Override
		public LeafSite build(){
			return new LeafSite(this);
		}
		
	}
	
}