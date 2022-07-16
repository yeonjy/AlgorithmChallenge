package pgm12922;
// 프로그래머스 - 수박수박수박수박수박수? 12922
public class Solution {
	public String solution(int n) {
		String[] wm = {"수", "박", "수박"};
		String answer = "";
		if (n % 2 == 0)
			for (int i = 0; i < n/2; i++)
				answer += wm[2];
		else {
			for (int i = 0; i < n; i++) {
				if (i%2 == 0)
					answer += wm[0];
				else
					answer += wm[1];
			}
		}
		return answer;
	}
}
