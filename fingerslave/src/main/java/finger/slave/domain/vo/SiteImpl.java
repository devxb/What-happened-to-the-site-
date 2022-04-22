package finger.slave.domain.vo;

import java.util.*;
import java.time.LocalDate;

public class SiteImpl implements Site{
	
	private String url;
	private LocalDate updatedDate;
	private List<Site> relationSites;
	private List<Keyword> keywords;
	
	@Override 
	public String getUrl(){
		return this.url;
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
	public Site getRelaitonSite(String url){
		for(Site site : this.relationSites) if(site.getUrl().equals(url)) return site;
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
	
}