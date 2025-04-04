import java.util.*;

class Solution {
    static List<Integer>[] lists;
    static boolean[] isVisited;
    static int[] test;
    static int answer;
    static int[] ans;
    static int n;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.ans = ans;
        this.n = n;
        
        isVisited = new boolean[n + 1];
        test = new int[5];
        
        lists = new ArrayList[q.length];
        for (int i = 0; i < q.length; i++) {
            lists[i] = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                lists[i].add(q[i][j]);
            }
        }
        
        backtracking(0, 1);
        
        return answer;
    }
    
    static void backtracking(int depth, int idx) {
        if (depth == 5) {
            if (isPossible()) {
                answer++;
            }
            return;
        }
        
        for (int i = idx; i <= n; i++) {
            if (!isVisited[i]) {
                test[depth] = i;
                isVisited[i] = true;
                backtracking(depth + 1, i + 1);
                isVisited[i] = false;
            }

        }
    }
    
    static boolean isPossible() {
        for (int i = 0; i < lists.length; i++) {
            int cnt = 0;
            List<Integer> list = lists[i];
            for (int now : test) {
                if (list.contains(now)) {
                    cnt++;
                }
            }
            if (cnt != ans[i]) {
                return false;
            }
        }
        return true;
    }
}