import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> test = new HashMap<>();
        Set<String> set = new HashSet<>(List.of(gems));
        
        // 2. 최소 구간 구하기
        int en = 0;
        int len = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        for (int st = 0; st < gems.length; st++) {
            while (en < gems.length && test.size() < set.size()) {
                test.put(gems[en], test.getOrDefault(gems[en], 0) + 1);
                en++;
            }
            if (test.size() == set.size() && en - st < len) {
                len = en - st;
                answer[0] = st + 1;
                answer[1] = en;
            }
            if (test.get(gems[st]) == 1) {
                test.remove(gems[st]);
            } else {
                test.put(gems[st], test.getOrDefault(gems[st], 0) -1);
            }
        }
        return answer;
    }
}