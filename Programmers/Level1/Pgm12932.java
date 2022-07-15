package pgm12932;
//프로그래머스 자연수 뒤집어 배열로 만들기 (12932)
public class Solution {
	public static int[] solution(long n) {
		int t = 0;
		long k = n;

		while(n > 0) {
			t++;
			n /= 10;
		}
		int[] answer = new int[t];
		for (int i = 0; i < t; i++) {
			answer[i] = (int)(k%10);
			k /= 10;
		}
		return answer;
	}
}
