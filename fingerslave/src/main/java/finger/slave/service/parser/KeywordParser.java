package finger.slave.service.parser;

import java.util.*;

import org.springframework.stereotype.Service;

import finger.slave.service.util.*;

@Service
public class KeywordParser implements FingerParser{
	
	@Override
	public Map<String, ParameterWrapper> parse(String content, String... keywords){
		Map<String, ParameterWrapper> keywordMap = new HashMap<String, ParameterWrapper>();
		for(String keyword : keywords){
			Integer patternCount = PatternCounter.count(content, keyword);
			keywordMap.put(keyword, ParameterWrapper.wrap(patternCount));
		}
		return keywordMap;
	}
	
}