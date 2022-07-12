package day2022_07_04;
// 두 개 뽑아서 더하기
import java.util.*;

public class Solution {
	public static ArrayList<Integer> solution(int[] numbers) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// 두 개 뽑아서 더하기
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int sum = numbers[i] + numbers[j];
				list.add(sum);
			}
		}
		HashSet<Integer> list2 = new HashSet<Integer>(list); // HashSet으로 중복 제거
		ArrayList<Integer> list3 = new ArrayList<Integer>(list2);
		Collections.sort(list3);
		return list3;
	}
}
