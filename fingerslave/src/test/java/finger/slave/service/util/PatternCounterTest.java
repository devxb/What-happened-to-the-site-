package finger.slave.service.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import static org.junit.jupiter.api.Assertions.*;

import static finger.slave.service.util.PatternCounter.count;

public class PatternCounterTest{
	
	@Test
	public void PatternCounter_KMP_TestCase1(){
		// given
		String content = "abcabdcabcabc";
		String pattern = "abcabc";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 1);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase2(){
		// given
		String content = "abcabcabcabc";
		String pattern = "abcabc";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 2);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase3(){
		// given
		String content = "AXAXXAXX";
		String pattern = "AXAXX";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 1);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase4(){
		// given
		String content = "ab  ab";
		String pattern = "  ";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 1);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase5(){
		// given
		String content = "한국어 찾기 테스트. 한국국어어한어국국어한국어국한어한국어국한";
		String pattern = "한국어";
			
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 3);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase6(){
		// given
		String content = "ABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAAB";
		String pattern = "ABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBAABBABAABBAABABBABAABABBAABBABAABABBABAABBAABABBABAABABBAABBABAABBAABABBAABBABAABABBABAABBAABABBA";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 1);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase7(){
		// given
		String content = "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";
		String pattern = "ACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCAACCACAACCAACACCACAACACCAACCACAACACCACAACCAACACCACAACACCAACCACAACCAACACCAACCACAACACCACAACCAACACCA";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 0);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase8(){
		// given
		String content = "  ab  ab";
		String pattern = "  ab";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 2);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase9(){
		// given
		String content = "banana banana";
		String pattern = "ana";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 2);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase10(){
		// given
		String content = "a";
		String pattern = "a";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 1);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase11(){
		// given
		String content = "abacababacabab";
		String pattern = "abacabab";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 1);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase12(){
		// given
		String content = "abacabacabacabaca";
		String pattern = "abaca";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 2);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase13(){
		// given
		String content = "ababababababababa";
		String pattern = "ababa";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 3);
	} 
	
	@Test
	public void PatternCounter_KMP_TestCase14(){
		// given
		String content = "abcababcabab";
		String pattern = "abcabab";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 1);
	} 
	
	@Test
	public void PatternCounter_KMP_TestCase15(){
		// given
		String content = "kitty";
		String pattern = "hello kitty";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 0);
	}
	
	@Test
	public void PatternCounter_KMP_TestCase16(){
		// given
		String content = "banana";
		String pattern = "bananananananananana";
		
		// when
		int patternCount = count(content, pattern);
		
		// then
		assertEquals(patternCount, 0);
	}
	
}