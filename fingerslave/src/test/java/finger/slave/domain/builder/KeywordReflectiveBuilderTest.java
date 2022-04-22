package finger.slave.service.builder;

import org.springframework.beans.factory.annotation.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.*;
import org.mockito.InjectMocks;

import java.util.*;
import java.time.*;

import finger.slave.domain.vo.*;
import finger.slave.service.util.*;

@ExtendWith(MockitoExtension.class)
public class KeywordReflectiveBuilderTest{
	
	@InjectMocks
	private KeywordReflectiveBuilder keywordBuilder;
	
	private String testWord = "test word";
	private Integer testCount = 777;
	
	@Test
	public void Keyword_Object_Make_Test(){
		// given
		Map<String, ParameterWrapper> parameterMap = this.getParameterMap();
		
		// when
		Keyword keyword = this.keywordBuilder.build(parameterMap);
		
		// then
		assertTrue(keyword.getWord().equals(this.testWord));
		assertEquals(keyword.getCount(), this.testCount);
	}
	
	@Test
	public void Keyword_Object_Make_Test_With_AlreadyMadeKeyword(){
		// given
		Keyword alreadyMadeKeyword = new KeywordImpl();
		Map<String, ParameterWrapper> parameterMap = this.getParameterMap();
		
		// when
		this.keywordBuilder.build(alreadyMadeKeyword, parameterMap);
		
		// then
		assertTrue(alreadyMadeKeyword.getWord().equals(this.testWord));
		assertEquals(alreadyMadeKeyword.getCount(), this.testCount);
	}
	
	private Map<String, ParameterWrapper> getParameterMap(){
		Map<String, ParameterWrapper> parameterMap = new HashMap<String, ParameterWrapper>();
		parameterMap.put("word", ParameterWrapper.wrap(this.testWord));
		parameterMap.put("count", ParameterWrapper.wrap(this.testCount));
		return parameterMap;
	}
		
}