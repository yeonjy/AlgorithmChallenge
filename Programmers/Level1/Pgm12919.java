package day2022_07_06;

import java.util.ArrayList;
import java.util.Arrays;

// 12919
public class Solution {
	public String solution(String[] seoul) {
		ArrayList<String> strList = new ArrayList<String>(Arrays.asList(seoul));
		int n = strList.indexOf("Kim");
		String answer = "�輭���� " + n + "�� �ִ�";
		return answer;
	}

}
