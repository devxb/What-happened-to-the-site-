package finger.slave.service.parser;

import java.util.*;

import org.springframework.stereotype.Service;

import finger.slave.service.util.*;

@Service
public class KeywordParser implements FingerParser<Integer>{
	
	@Override
	public Map<String, Integer> parse(String content, String... keywords){
		Map<String, Integer> keywordMap = new HashMap<String, Integer>();
		for(String keyword : keywords){
			Integer patternCount = PatternCounter.count(content, keyword);
			keywordMap.put(keyword, patternCount);
		}
		return keywordMap;
	}
	
}