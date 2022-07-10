package pgm86051;

public class Solution {
	public int solution(int[] numbers) {
		int answer = 45;
		for (int tmp : numbers) {
			answer -= tmp;
		}
		return answer;
	}
}