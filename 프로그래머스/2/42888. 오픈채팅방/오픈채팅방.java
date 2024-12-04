import java.util.*;

public class Solution {
    static final String ENTER = "Enter";
    static final String ENTER_SENTENCE = "님이 들어왔습니다.";
    static final String LEAVE_SENTENCE = "님이 나갔습니다.";
    static final String CHANGE = "Change";

    public String[] solution(String[] record) {
        String[] answer;
        int senCnt = 0;

        // 최종 닉네임 저장
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] line = record[i].split(" ");
            if (line[0].equals(ENTER) || line[0].equals(CHANGE)) {
                map.put(line[1], line[2]);
            }
            if (!line[0].equals(CHANGE)) {
                senCnt++;
            }
        }
        answer = new String[senCnt];
        senCnt = -1;

        for (int i = 0; i < record.length; i++) {
            String[] line = record[i].split(" ");
            if (line[0].equals(CHANGE)) {
                continue;
            }
            if (line[0].equals(ENTER)) {
                answer[++senCnt] = map.get(line[1]) + ENTER_SENTENCE;
            } else {
                answer[++senCnt] = map.get(line[1]) + LEAVE_SENTENCE;
            }
        }

        return answer;
    }
}
