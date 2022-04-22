package finger.slave.service.builder;

import org.springframework.stereotype.Service;

import java.util.*;
import java.lang.reflect.*;

import finger.slave.domain.vo.*;
import finger.slave.service.util.*;

@Service
public class KeywordReflectiveBuilder implements ReflectiveBuilder<Keyword>{
	
	@Override
	public Keyword build(Map<String, ParameterWrapper> parameters){
		Keyword keyword = new KeywordImpl();
		return this.build(keyword, parameters);
	}
	
	@Override
	public Keyword build(Keyword keyword, Map<String, ParameterWrapper> parameters){
		Class keywordClass = keyword.getClass();
		for(Map.Entry<String, ParameterWrapper> entry : parameters.entrySet()){
			Field declaredField = this.getField(keywordClass, entry.getKey());
			declaredField.setAccessible(true);
			this.setField(keyword, declaredField, entry.getValue());
		}
		return keyword;
	}
	
	private Field getField(Class keywordClass, String fieldName){
		try{
			return keywordClass.getDeclaredField(fieldName);
		}catch(Exception e){
			throw new IllegalArgumentException("KeywordReflectiveBuilder의 key로 잘못된 값이 들어옴");
		}
	}
	
	private void setField(Keyword keyword, Field field, ParameterWrapper wrapper){
		try{
			Class fieldClass = field.getType();
			field.set(keyword, fieldClass.cast(wrapper.unWrap()));
		}catch(Exception e){
			throw new IllegalArgumentException("KeywordReflectiveBuilder의 " + field.getName() + "필드의 argument로 잘못된 값이 들어옴");
		}
	}
	
}