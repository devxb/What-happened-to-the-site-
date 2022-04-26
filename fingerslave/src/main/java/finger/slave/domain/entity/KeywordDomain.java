package finger.slave.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="KEYWORD")
public class KeywordDomain{
	
	@Id
	@GeneratedValue
	@Column(name="KEYWORD_ID")
	private Long keywordId;
	
	@Column(name="WORD")
	private String word;
	
	@Column(name="COUNT")
	private Integer count;
	
	@ManyToOne
	@JoinColumn(name="SITE_ID")
	private SiteDomain site;
	
	public String getWord(){
		return this.word;
	}
	
	public Integer getCount(){
		return this.count;
	}
	
	public KeywordDomain(Builder builder){
		this.word = builder.word;
		this.count = builder.count;
		this.site = builder.site;
	}
	
	public static class Builder{
		
		private String word;
		private Integer count;
		private SiteDomain site;
		
		public Builder word(String word){
			this.word = word;
			return this;
		}
		
		public Builder count(Integer count){
			this.count = count;
			return this;
		}
		
		public Builder site(SiteDomain site){
			this.site = site;
			return this;
		}
		
		public KeywordDomain build(){
			return new KeywordDomain(this);
		}
		
	}
	
}