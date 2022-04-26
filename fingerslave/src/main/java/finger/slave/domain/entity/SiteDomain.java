package finger.slave.domain.entity;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="SITE")
public class SiteDomain{
	
	@Id
	@GeneratedValue
	@Column(name="SITE_ID")
	private Long siteId;
	
	@Column(name="NAME", nullable=false)
	private String siteName;
	
	@Column(name="CONTENT_LENGTH", nullable=false)
	private Integer contentLength;
	
	@Column(name="LAST_UPDATED_DATE", nullable=false)
	private LocalDate lastUpdatedDate;
	
	@Column(name="KEYWORDS")
	@OneToMany(mappedBy="site", fetch=FetchType.LAZY, orphanRemoval=true, cascade=CascadeType.ALL)
	@OrderBy("word asc")
	private List<KeywordDomain> keywords;
	
	public String getSiteName(){
		return this.siteName;
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
	
	public SiteDomain(Builder builder){
		this.siteName = builder.siteName;
		this.contentLength = builder.contentLength;
		this.lastUpdatedDate = builder.lastUpdatedDate;
		this.keywords = builder.keywords;
	}
	
	public static class Builder{
		
		private String siteName;
		private Integer contentLength;
		private LocalDate lastUpdatedDate;
		private List<KeywordDomain> keywords;
		
		public Builder siteName(String siteName){
			this.siteName = siteName;
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
		
		public SiteDomain build(){
			return new SiteDomain(this);
		}
		
	}
	
}