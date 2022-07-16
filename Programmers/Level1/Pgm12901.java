package pgm12901;
// 프로그래머스 - 2016년 (12901)
import java.util.HashMap;

public class Solution {
	public String solution(int a, int b) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] one = {1, 3, 5, 7, 8, 10, 12};
		int[] zero = {4, 6, 9, 11};
		String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int day = 0;
		for(int i : one)
			map.put(i, 31);
		for(int i : zero)
			map.put(i, 30);
		map.put(2, 29);
		for(int i = 1; i < a; i++) {
			day += map.get(i);
		}
		day += b - 1;
		day %= 7;
		return dayOfWeek[day];
	}
}
