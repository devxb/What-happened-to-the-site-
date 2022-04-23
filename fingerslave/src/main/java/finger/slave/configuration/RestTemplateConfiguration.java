package finger.slave.configuration;

import org.springframework.context.annotation.*;
import org.springframework.web.client.*;
import org.springframework.http.client.*;

import org.apache.http.client.*;
import org.apache.http.impl.client.*;

@Configuration
public class RestTemplateConfiguration{
	
	@Bean
	public RestTemplate restTemplate(){
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		HttpComponentsClientHttpRequestFactory httpClientFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		httpClientFactory.setConnectTimeout(10000);
		
		return new RestTemplate(httpClientFactory);
	}
	
}