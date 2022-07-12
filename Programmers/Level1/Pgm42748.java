package pgm42748;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public static int[] solution(int[] array, int[][] commands) {
		int n = commands.length;
		List<Integer> listA = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			int[] arr1 = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(arr1);
			System.out.println(Arrays.toString(arr1));
			int k = arr1[commands[i][2] - 1];
			listA.add(k);
			System.out.println("k°ª: " + k);
		
		}
		int[] answer = listA.stream().mapToInt(i->i).toArray();
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
