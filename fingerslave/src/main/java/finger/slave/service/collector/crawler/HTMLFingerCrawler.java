package finger.slave.service.collector.crawler;

import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.net.*;

@Service(value="HTMLFingerCrawler")
public class HTMLFingerCrawler implements FingerCrawler{
	
	private final RestTemplate restTemplate;
	
	@Override
	public String crawl(String uri){
		try{
			return restTemplate.getForObject(new URI(uri), String.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public HTMLFingerCrawler(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}
	
}