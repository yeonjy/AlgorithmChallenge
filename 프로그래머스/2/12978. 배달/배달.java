import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class Node {
        int start;
        int end;
        int time;

        Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    static int N;
    static int K;
    static List<Node>[] nodes;
    static int[][] times;
    static boolean[] isVisited;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        this.N = N;
        this.K = K;
        times = new int[N + 1][N + 1];
        nodes = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int st = road[i][0];
            int en = road[i][1];
            int time = road[i][2];
            nodes[st].add(new Node(st, en, time));
            nodes[en].add(new Node(en, st, time));
        }

        for (int i = 0; i < nodes[1].size(); i++) {
            isVisited = new boolean[N + 1];
            isVisited[1] = true;
            dfs(nodes[1].get(i));
        }
        for (int i = 2; i < N + 1; i++) {
            if (times[1][i] <= K && times[1][i] != 0) {
                answer++;
            }
        }
        return answer + 1;
    }

    static void dfs(Node n) {
        if (times[n.start][n.end] != 0 && times[n.start][n.end] < n.time) {
            return;
        }
        times[n.start][n.end] = n.time;

        if (isVisited[n.end]) {
            return;
        }
        isVisited[n.end] = true;
        for (int i = 0; i < nodes[n.end].size(); i++) {
            Node next = nodes[n.end].get(i);
            dfs(new Node(n.start, next.end, n.time + next.time));
        }
        isVisited[n.end] = false;
    }
}
