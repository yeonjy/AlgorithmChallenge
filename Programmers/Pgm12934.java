package pgm12934;
// ���α׷��ӽ� ���� ������ �Ǻ� (12934)
public class Solution {
	public static long solution(long n) {
		double result = Math.sqrt(n);
		long answer;
		if (result % 1 == 0) {
			answer = (long) Math.pow(result + 1, 2);
			return answer;
		}
		else {
			answer = -1;
		}
		return answer;
	}
}
