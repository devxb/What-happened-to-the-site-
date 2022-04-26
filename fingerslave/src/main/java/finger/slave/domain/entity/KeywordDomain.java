package finger.slave.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="KEYWORD")
public class KeywordDomain{
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long keywordId;
	
	@Column(name="WORD")
	private String word;
	
	@Column(name="COUNT")
	private Integer count;
	
	@ManyToOne
	@JoinColumn(name="ID")
	private RootSiteDomain rootSite;
	
	public String getWord(){
		return this.word;
	}
	
	public Integer getCount(){
		return this.count;
	}
	
	public KeywordDomain(Builder builder){
		this.word = builder.word;
		this.count = builder.count;
		this.rootSite = builder.rootSite;
	}
	
	public static class Builder{
		
		private String word;
		private Integer count;
		private RootSiteDomain rootSite;
		
		public Builder word(String word){
			this.word = word;
			return this;
		}
		
		public Builder count(Integer count){
			this.count = count;
			return this;
		}
		
		public Builder rootSite(RootSiteDomain rootSite){
			this.rootSite = rootSite;
			return this;
		}
		
		public KeywordDomain build(){
			return new KeywordDomain(this);
		}
		
	}
	
}