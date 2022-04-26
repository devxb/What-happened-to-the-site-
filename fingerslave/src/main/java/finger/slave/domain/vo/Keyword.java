package finger.slave.domain.vo;

public interface Keyword{
	
	public String getWord();
	public Integer getCount();
	
	public abstract static class KeywordBuilder<T extends Keyword>{
		
		protected String word;
		protected Integer count;
		
		public KeywordBuilder<T> word(String word){
			this.word = word;
			return this;
		}
		
		public KeywordBuilder<T> count(Integer count){
			this.count = count;
			return this;
		}
		
		abstract public T build();
		
	}
	
}