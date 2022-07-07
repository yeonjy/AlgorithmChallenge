package day2022_07_06;

import java.util.Arrays;

public class P12917 {
	public static String solution(String s) {
		char[] arr = s.toCharArray();
		
		Arrays.sort(arr);	
		for (int i = 0; i < arr.length/2; i++) {
			char temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
		String answer = new String(arr);
		System.out.println(answer);
		return answer;
	}

}
