package finger.slave.configuration;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.config.*;
import org.springframework.core.io.*;
import java.nio.charset.*;

@Configuration
public class PropertyConfiguration{
	
	@Bean
	public PropertiesFactoryBean fingerProperties(){
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		ClassPathResource classPathResource = new ClassPathResource("application.properties");
		
		propertiesFactoryBean.setLocation(classPathResource);
		propertiesFactoryBean.setFileEncoding(StandardCharsets.UTF_8.toString());
		
		return propertiesFactoryBean;
	}
	
}