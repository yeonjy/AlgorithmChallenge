package Pgm81301;

// 숫자 문자열과 영단어 (81301)
public class Solution {
	public static int solution(String s) {
		String[] num = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] intNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for (int i = 0; i < 10; i++) {
			s = s.replaceAll(num[i], intNum[i]);
			}
		int answer = Integer.parseInt(s);
		return answer;
	}
}
