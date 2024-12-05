import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int len;
    static String s;

    public int solution(String s) {
        int answer = s.length();

        len = s.length();
        this.s = s;

        for (int i = 1; i <= len / 2; i++) {
            answer = Math.min(answer, getZip(i));
        }
        return answer;
    }

    static int getZip(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int i = n; i <= len; i += n) {
            list.add(s.substring(i - n, i));
        }

        list.add("");
        int cnt = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                cnt++;
            } else {
                if (cnt == 1) {
                    sb.append(list.get(i));
                } else {
                    sb.append(cnt + list.get(i));
                }
                cnt = 1;
            }
        }

        if (len % n != 0) {
            sb.append(s.substring(len - (len % n), len));
        }
        return sb.length();
    }
}
