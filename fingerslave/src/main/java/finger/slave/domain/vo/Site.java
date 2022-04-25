package finger.slave.domain.vo;

import java.time.LocalDate;
import java.util.List;

public interface Site{
	
	public String getUri();
	public Integer getContentLength();
	public LocalDate getUpdatedDate();
	public List<Site> getRelationSites();
	public Site getRelaitonSite(String uri);
	public void setRelationSite(Site site);
	public void setRelationSites(List<Site> sites);
	public List<Keyword> getKeywords();
	public Keyword getKeyword(String keyword);
	
	public static abstract class SiteBuilder<T extends Site>{
		
		public abstract SiteBuilder<T> uri(String uri);
		public abstract SiteBuilder<T> contentLength(Integer contentLength);
		public abstract SiteBuilder<T> updatedDate(LocalDate updatedDate);
		public abstract SiteBuilder<T> keywords(List<Keyword> keywords);
		public abstract SiteBuilder<T> keyword(Keyword keyword);
		public abstract T build();
		
	}
	
}