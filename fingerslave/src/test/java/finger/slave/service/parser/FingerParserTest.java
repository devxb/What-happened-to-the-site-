package finger.slave.service.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import finger.slave.service.util.*;

public class FingerParserTest{
	
	private HyperLinkParser hyperLinkParser = new HyperLinkParser();
	
	@Test
	public void Parse_HyperLinks_Google_Test(){
		// given
		String uri = "https://test.domain";
		String content = this.getContent();
		
		// when
		Map<String, ParameterWrapper> hyperLinkMap = this.hyperLinkParser.parse(content, uri);
		
		// then
		assertTrue(!hyperLinkMap.isEmpty());
	}
	
	private String getContent(){
		return "<!DOCTYPE.HTML><HTML><head><title>test-title</title></head><body><a href='https://test.domain/test-url' /></body></HTML>";
	}
	
}