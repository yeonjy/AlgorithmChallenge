package day2022_07_04;
// �� �� �̾Ƽ� ���ϱ�
import java.util.*;

public class Solution {
	public static ArrayList<Integer> solution(int[] numbers) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// �� �� �̾Ƽ� ���ϱ�
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int sum = numbers[i] + numbers[j];
				list.add(sum);
			}
		}
		HashSet<Integer> list2 = new HashSet<Integer>(list); // HashSet���� �ߺ� ����
		ArrayList<Integer> list3 = new ArrayList<Integer>(list2);
		Collections.sort(list3);
		return list3;
	}
}
