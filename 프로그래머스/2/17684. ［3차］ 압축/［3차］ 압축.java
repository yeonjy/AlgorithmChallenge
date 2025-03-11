import java.util.*;

public class Solution {
    static public List<Integer> solution(String msg) {
        int length = msg.length();
        List<Integer> answer = new ArrayList<>();

        // [1] 사전 초기화
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            String alpha = String.valueOf((char) ('A' + i - 1));
            dictionary.put(alpha, i);

        }

        // [2] 돌려
        int count = 26;
        for (int i = 0; i < length; i++) {
            StringBuilder now = new StringBuilder();
            while (i < length && dictionary.containsKey(now.toString() + msg.charAt(i))) {
                now.append(msg.charAt(i));
                i++;
            }

            answer.add(dictionary.get(now.toString()));

            if (i < length) {
                dictionary.put(now.append(msg.charAt(i)).toString(), ++count);
                i--;
            }
        }

        return answer;
    }
}