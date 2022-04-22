package finger.slave.service.util;

public class ParameterWrapper{
	
	private Object parameter;
	
	public static ParameterWrapper wrap(Object object){
		return new ParameterWrapper(object);
	}
	
	public Object unWrap(){
		return this.parameter;
	}
	
	private ParameterWrapper(){
		throw new IllegalArgumentException();
	}
	
	private ParameterWrapper(Object parameter){
		this.parameter = parameter;
	}
	
}