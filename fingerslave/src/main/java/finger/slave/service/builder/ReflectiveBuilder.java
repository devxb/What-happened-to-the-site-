package finger.slave.service.builder;

import java.util.Map;
import finger.slave.service.util.*;

public interface ReflectiveBuilder<T extends Object>{
	
	public T build(Map<String, ParameterWrapper> parameters);
	public T build(T target, Map<String, ParameterWrapper> parameters);
	
}