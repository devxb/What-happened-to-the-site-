package finger.slave.service.parser;

import finger.slave.service.util.ParameterWrapper;

import java.util.Map;

public interface FingerParser{
	
	public Map<String, ParameterWrapper> parse(String content, String... parameters);
	
}