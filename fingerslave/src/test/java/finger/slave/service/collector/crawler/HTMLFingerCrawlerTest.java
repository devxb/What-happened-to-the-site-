package finger.slave.service.collector.crawler;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.*;
import org.mockito.*;

// @ExtendWith(MockitoExtension.class)
@SpringBootTest
public class HTMLFingerCrawlerTest{
	
	// @InjectMocks
	@Autowired
	private HTMLFingerCrawler crawler;
	
	// @Mock
	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void Crawl_Gitofolio_Test(){
		// given
		String uri = "https://google.com";
			
		// when
		String content = this.crawler.crawl(uri);
			
		// then
		assertTrue(!content.equals(""));
	}
	
}