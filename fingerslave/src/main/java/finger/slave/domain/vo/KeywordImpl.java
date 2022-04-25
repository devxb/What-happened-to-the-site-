package finger.slave.domain.vo;

public class KeywordImpl implements Keyword{
	
	private final String word;
	private final Integer count;
	
	@Override
	public String getWord(){
		return this.word;
	}
	
	@Override
	public Integer getCount(){
		return this.count;
	}
	
	private KeywordImpl(KeywordImplBuilder builder){
		this.word = builder.word;
		this.count = builder.count;
	}
	
	public static class KeywordImplBuilder extends KeywordBuilder<KeywordImpl>{
		
		private String word;
		private Integer count;
		
		@Override
		public KeywordBuilder<KeywordImpl> word(String word){
			this.word = word;
			return this;
		}
		
		@Override
		public KeywordBuilder<KeywordImpl> count(Integer count){
			this.count = count;
			return this;
		}
		
		@Override
		public KeywordImpl build(){
			return new KeywordImpl(this);
		}
		
	}
	
}