package finger.slave.domain.vo;

import java.time.LocalDate;
import java.util.List;

public interface Site{

	public String getSiteInfo();
	public void addKeyword(Keyword keyword);
	public void addKeywords(List<Keyword> keywords);
	public void addRelationSite(Site site);
	public void addRelationSites(List<Site> sites);
	
	public abstract static class SiteBuilder<T extends Site>{
		
		protected String uri;
		protected Integer contentLength;
		protected LocalDate updatedDate;
		
		public SiteBuilder<T> uri(String uri){
			this.uri = uri;
			return this;
		}
		
		public SiteBuilder<T> contentLength(Integer contentLength){
			this.contentLength = contentLength;
			return this;
		}
		
		public SiteBuilder<T> updatedDate(LocalDate updatedDate){
			this.updatedDate = updatedDate;
			return this;
		}
		
		public abstract T build();
		
	}
	
}