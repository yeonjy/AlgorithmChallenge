import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long total = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            total *= i;
        }

        k--;
        int idx = 0;
        while (idx < n) {
            total = total / (n - idx);
            answer[idx++] = list.remove((int) (k / total));
            k = k % total;
        }
        return answer;
    }
}