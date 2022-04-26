package finger.slave.domain.entity;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="ROOT_SITE")
public class RootSiteDomain{
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long rootSiteId;
	
	@Column(name="NAME", nullable=false)
	private String rootSiteName;
	
	@Column(name="CONTENT_LENGTH", nullable=false)
	private Integer contentLength;
	
	@Column(name="LAST_UPDATED_DATE", nullable=false)
	private LocalDate lastUpdatedDate;
	
	@Column(name="KEYWORDS")
	@OneToMany(mappedBy="rootSite", fetch=FetchType.LAZY, orphanRemoval=true, cascade=CascadeType.ALL)
	@OrderBy("word asc")
	private List<KeywordDomain> keywords;
	
	public String getRootSiteName(){
		return this.rootSiteName;
	}
	
	public Integer getContentLength(){
		return this.contentLength;
	}
	
	public LocalDate getLastUpdatedDate(){
		return this.lastUpdatedDate;
	}
	
	public List<KeywordDomain> getKeywords(){
		return this.keywords;
	}
	
	public KeywordDomain getKeyword(String findWord){
		for(KeywordDomain keyword : this.keywords) if(findWord.equals(keyword.getWord())) return keyword;
		return null;
	}
	
	public RootSiteDomain(Builder builder){
		this.rootSiteName = builder.rootSiteName;
		this.contentLength = builder.contentLength;
		this.lastUpdatedDate = builder.lastUpdatedDate;
		this.keywords = builder.keywords;
	}
	
	public static class Builder{
		
		private String rootSiteName;
		private Integer contentLength;
		private LocalDate lastUpdatedDate;
		private List<KeywordDomain> keywords;
		
		public Builder rootSiteName(String rootSiteName){
			this.rootSiteName = rootSiteName;
			return this;
		}
		
		public Builder contentLength(Integer contentLength){
			this.contentLength = contentLength;
			return this;
		}
		
		public Builder lastUpdatedDate(LocalDate lastUpdatedDate){
			this.lastUpdatedDate = lastUpdatedDate;
			return this;
		}
		
		public Builder keywords(List<KeywordDomain> keywords){
			this.keywords = keywords;
			return this;
		}
		
		public RootSiteDomain build(){
			return new RootSiteDomain(this);
		}
		
	}
	
}