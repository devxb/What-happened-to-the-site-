package finger.slave.service.util;

import static java.lang.Math.max;

public class PatternCounter{
	
	/*
		KMP 알고리즘을 기반으로 동작함
		case1. pattern이 겹치면, 겹치는 부분은 하나의 패턴으로 카운팅 함
		동작 검증에 사용된 모든 테스트 케이스는 test폴더의 finger.slave.service.util.PatternCounterTest에서 확인할 수 있음
	*/
	
	public static int count(String content, String pattern){
		int[] pi = getPi(pattern);
		return kmp(content, pattern, pi);
	}
	
	private static int[] getPi(String pattern){
		int[] pi = new int[pattern.length()];
		for(int i = 1; i < pattern.length(); i++){
			int hit = 0;
			while(i+hit < pattern.length()){
				if(!isEqualChar(pattern.charAt(hit), pattern.charAt(i+hit))) break;
				pi[i+hit] = max(pi[i+hit], hit+1);
				hit++;
			}
		}
		return pi;
	}
	
	private static int kmp(String content, String pattern, int[] pi){
		int patternCount = 0;
		for(int i = 0; i < content.length(); i++){
			int hit = 0;
			while(hit < pattern.length() && (hit + i) < content.length()){
				if(!isEqualChar(content.charAt(i+hit), pattern.charAt(hit))){
					hit--;
					if(hit < 0) break;
					i += hit - pi[hit] + 1;
					hit = pi[hit];
					continue;
				}
				hit++;
			}
			if(hit == pattern.length()){
				i += hit-1;
				patternCount++;
			}
		}
		return patternCount;
	}
	
	private static boolean isEqualChar(char standard, char target){
		return standard == target;
	}
	
}