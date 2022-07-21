package pgm17682;

// 프로그래머스 - [1차] 다트게임 (17682)
class Solution {
	public static int solution(String dartResult) {

		String[] str = dartResult.split("");

		int[] score = new int[] { 0, 0, 0 };
		int n = -1;

		for (int i = 0; i < str.length; i++) {
			if (Character.isDigit(str[i].charAt(0))) {
				n++;
				if (Character.isDigit(str[i + 1].charAt(0))) {
					score[n] = 10;
					i++;
				} else
					score[n] = Integer.parseInt(str[i]);

				if (str[++i].equals("D")) {
					score[n] = (int) Math.pow(score[n], 2);
				} else if (str[i].equals("T"))
					score[n] = (int) Math.pow(score[n], 3);

			} else if (str[i].equals("*")) {
				if (n == 0)
					score[n] *= 2;
				else {
					score[n - 1] *= 2;
					score[n] *= 2;
				}
			} else if (str[i].equals("#"))
				score[n] *= (-1);

		}

		int answer = score[0] + score[1] + score[2];
		return answer;
	}
}