package finger.slave.service.builder;

import org.springframework.stereotype.Service;

import java.util.*;
import java.lang.reflect.*;

import finger.slave.domain.vo.*;
import finger.slave.service.util.*;

@Service
public class SiteReflectiveBuilder implements ReflectiveBuilder<Site>{
	
	@Override
	public Site build(Map<String, ParameterWrapper> parameters){
		Site site = new SiteImpl();
		return this.build(site, parameters);
	}
	
	@Override
	public Site build(Site site, Map<String, ParameterWrapper> parameters){
		Class siteClass = site.getClass();
		for(Map.Entry<String, ParameterWrapper> entry : parameters.entrySet()){
			Field declaredField = this.getField(siteClass, entry.getKey());
			declaredField.setAccessible(true);
			this.setField(site, declaredField, entry.getValue());
		}
		return site;
	}
	
	private Field getField(Class siteClass, String fieldName){
		try{
			return siteClass.getDeclaredField(fieldName);
		}catch(Exception e){
			throw new IllegalArgumentException("SiteReflectiveBuilder의 key로 잘못된 값이 들어옴");
		}
	}
	
	private void setField(Site site, Field field, ParameterWrapper wrapper){
		try{
			Class fieldClass = field.getType();
			field.set(site, fieldClass.cast(wrapper.unWrap()));
		}catch(Exception e){
			throw new IllegalArgumentException("SiteReflectiveBuilder의 " + field.getName() + "필드의 argument로 잘못된 값이 들어옴");
		}
	}
		
}