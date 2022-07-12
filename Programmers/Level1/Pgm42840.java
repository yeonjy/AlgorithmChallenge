package pgm42840;

import java.util.*;

// 프로그래머스 - 모의고사 42840
public class Solution {
	public static int[] solution(int[] answers) {
		int k = 0, j = 0, aSize = answers.length, aMax = 0;
		int[] first = new int[aSize], second = new int[aSize], third = new int[aSize], n = new int[3];
		
		for (int i : answers) {
			first[k] = k % 5 + 1;
			if (k % 2 != 0 && k/2 % 4 == 0) {
				second[k] = 1;
			}
			else second[k] = k % 2 == 0 ? 2 : k/2 % 4 + 2;
			
			switch(k%10/2) {
			case 0: third[k] = 3;
				break;
			case 1: third[k] = 1;
				break;
			case 2: third[k] = 2;
				break;
			case 3: third[k] = 4;
				break;
			default: third[k] = 5;
				break;
			}
			if (first[k] == i)
				n[0]++;
			if (second[k] == i)
				n[1]++;
			if (third[k] == i)
				n[2]++;
			k++;
		}
		List<Integer> listA = new ArrayList<Integer>();
		for(int i : n) aMax = Math.max(i, aMax);
		for (int i=0; i < 3; i++) if (n[i] == aMax) listA.add(i+1);
		int[] answer = listA.stream().mapToInt(i->i).toArray();
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
