import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long st = 1;
        long en = (long) times[0] * n;
        long mid;
        while (st < en) {
            mid = (st + en) / 2;
            long people = 0;
            for (int time : times) {
                people += mid / time;
                if (people >= n) {
                    break;
                }
            }
            if (people < n) {
                st = mid + 1;
            } else {
                en = mid;
            }
        }
        
        return st;
    }
}