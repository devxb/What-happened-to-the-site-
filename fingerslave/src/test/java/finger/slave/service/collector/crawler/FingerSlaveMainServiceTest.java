package finger.slave.service.collector.crawler;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.*;
import org.mockito.*;

import finger.slave.service.parser.*;
import finger.slave.service.util.*;

import java.util.*;

@SpringBootTest
public class FingerSlaveMainServiceTest{
	
	@Autowired
	@Qualifier("HTMLFingerCrawler")
	private FingerCrawler crawler;
	
	@Autowired
	@Qualifier("hyperLinkParser")
	private FingerParser hyperLinkParser;
	
	@Test
	public void Crawl_Google_Test(){
		// given
		String uri = "https://google.com";
			
		// when
		String content = this.crawler.crawl(uri);
			
		// then
		assertTrue(!content.equals(""));
	}
	
	@Test
	public void Parse_HyperLinks_Google_Test(){
		// given
		String uri = "https://google.com";
		
		// when
		String content = this.crawler.crawl(uri);
		Map<String, ParameterWrapper> hyperLinkMap = this.hyperLinkParser.parse(content, uri);
		
		// then
		assertTrue(!hyperLinkMap.isEmpty());
	}
	
}