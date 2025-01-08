import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int n;
    static boolean[] isVisited;
    static List<Integer>[] arr;
    static int count;
    static int difference = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        this.n = n;
        arr = new List[n + 1];

        // 각 송전탑마다 연결되어 있는 송전탑
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            arr[a].add(b);
            arr[b].add(a);
        }

        // 전선 하나씩 끊어보기
        for (int i = 0; i < wires.length; i++) {
            count = 0;
            isVisited = new boolean[n + 1];
            int a = wires[i][0];
            int b = wires[i][1];

            arr[a].remove(arr[a].indexOf(b));
            arr[b].remove(arr[b].indexOf(a));

            dfs(a);
            if (difference > Math.abs(n - 2 * count)) {
                difference = Math.abs(n - 2 * count);
            }

            arr[a].add(b);
            arr[b].add(a);
        }

        return difference;
    }

    private static void dfs(int now) {
        isVisited[now] = true;
        count++;

        for (int next : arr[now]) {
            if (!isVisited[next]) {
                dfs(next);
            }
        }
    }
}
