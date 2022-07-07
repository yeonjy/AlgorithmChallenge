package day2022_07_06;


public class P12948 {
	public static String solution(String phone_number) {
		int size = phone_number.length();
		String last = phone_number.substring(size - 4);
		
		String answer = new String();
		for (int i = 0; i < size - 4; i++) {
			answer = answer + "*";
		}
		answer = answer + last;
		
		return answer;
	}
}
