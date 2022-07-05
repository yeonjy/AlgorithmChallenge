package day2022_07_05;

//프로그래머스 - 같은 숫자는 싫어 (12906)
import java.util.*;
import java.util.stream.*;

public class Solution {
	public static int[] solution(int[] arr) {
		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList()); // List 변환
		List<Integer> rm = new ArrayList<Integer>();
		
		int tmp = 0;

		for (int i = 0; i < arrList.size() - 1; i++) {
			if (arrList.get(i) == arrList.get(i + 1)) {
				arrList.set(i, -1);
			}
		}
		rm.add(-1);
		arrList.removeAll(rm);

		int[] ans = new int[arrList.size()];
		for (int i = 0; i < arrList.size(); i++) {
			ans[i] = arrList.get(i);
		}

		return ans;
	}
}