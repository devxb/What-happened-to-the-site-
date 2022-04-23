package finger.slave.service.parser;

import finger.slave.service.util.ParameterWrapper;

import java.util.Map;

public interface FingerParser<T extends Object>{
	
	public Map<String, ParameterWrapper> parse(String content, T... parameters);
	
}