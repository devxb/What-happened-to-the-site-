package finger.slave.domain.vo;

public class KeywordImpl implements Keyword{
	
	private String word;
	private Integer count;
	
	@Override
	public String getWord(){
		return this.word;
	}
	
	@Override
	public Integer getCount(){
		return this.count;
	}
	
}