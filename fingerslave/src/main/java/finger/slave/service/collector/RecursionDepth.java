package finger.slave.service.collector;

public enum RecursionDepth{
	
	NONE(0),
	EASY(3),
	NORMAL(7),
	HARD(10),
	INFINITE(100);
	
	private final int depth;
	
	RecursionDepth(int depth){
		this.depth = depth;
	}
	
	public int depth(){
		return this.depth;
	}
	
}