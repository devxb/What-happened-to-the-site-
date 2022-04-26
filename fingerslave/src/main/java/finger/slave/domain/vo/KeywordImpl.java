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
	
	private KeywordImpl(){
		this(null);
	}
	
	private KeywordImpl(KeywordImplBuilder builder){
		this.word = builder.word;
		this.count = builder.count;
	}
	
	public static class KeywordImplBuilder extends KeywordBuilder<KeywordImpl>{
		
		@Override
		public KeywordImpl build(){
			return new KeywordImpl(this);
		}
		
	}
	
}