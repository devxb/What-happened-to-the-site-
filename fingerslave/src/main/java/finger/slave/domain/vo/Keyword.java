package finger.slave.domain.vo;

public interface Keyword{
	
	public String getWord();
	public Integer getCount();
	
	public static abstract class KeywordBuilder<T extends Keyword>{
		
		abstract public KeywordBuilder<T> word(String word);
		abstract public KeywordBuilder<T> count(Integer count);
		abstract public T build();
		
	}
	
}