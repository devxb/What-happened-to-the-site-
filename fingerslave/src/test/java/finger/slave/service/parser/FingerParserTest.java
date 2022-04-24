package finger.slave.service.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import finger.slave.service.util.*;

public class FingerParserTest{
	
	private FingerParser hyperLinkParser = new HyperLinkParser();
	private FingerParser keywordParser = new KeywordParser();
	
	@Test
	public void Parse_HyperLinks_Test(){
		// given
		String uri = "https://test.domain";
		String content = this.getContent();
		
		// when
		Map<String, ParameterWrapper> hyperLinkMap = this.hyperLinkParser.parse(content, uri);
		
		// then
		assertTrue(!hyperLinkMap.isEmpty());
	}
	
	@Test
	public void Parse_Keyword_Test(){
		// given
		String content = this.getContent();
		
		// when
		Map<String, ParameterWrapper> keywordMap = this.keywordParser.parse(content, "채용", "가입", "recruit", "Join", "join", "인턴", "모집", "신청");
		
		// then
		assertTrue(!keywordMap.isEmpty());
		assertEquals(keywordMap.get("채용").unWrap(), 4);
		assertEquals(keywordMap.get("가입").unWrap(), 3);
		assertEquals(keywordMap.get("신청").unWrap(), 0);
		assertEquals(keywordMap.get("인턴").unWrap(), 2);
		assertEquals(keywordMap.get("recruit").unWrap(), 1);
		assertEquals(keywordMap.get("Join").unWrap(), 2);
		assertEquals(keywordMap.get("join").unWrap(), 1);
		assertEquals(keywordMap.get("모집").unWrap(), 3);
	}
	
	private String getContent(){
		return "<!DOCTYPE.HTML><HTML><head><title>test-title</title></head><body><a href='https://test.domain/test-url'/> <pre>채용 채용 채용 recruit 채용 가입 가입 Join 가입 Join join 인턴 모집 모집 인턴 모집 </pre></body></HTML>";
	}
	
}