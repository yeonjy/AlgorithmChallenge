package pgm12922;
// ���α׷��ӽ� - ���ڼ��ڼ��ڼ��ڼ��ڼ�? 12922
public class Solution {
	public String solution(int n) {
		String[] wm = {"��", "��", "����"};
		String answer = "";
		if (n % 2 == 0)
			for (int i = 0; i < n/2; i++)
				answer += wm[2];
		else {
			for (int i = 0; i < n; i++) {
				if (i%2 == 0)
					answer += wm[0];
				else
					answer += wm[1];
			}
		}
		return answer;
	}
}
