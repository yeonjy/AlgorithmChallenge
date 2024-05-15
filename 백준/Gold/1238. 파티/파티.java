import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int[][] dist;
    static ArrayList<Node>[] graph;
    static int N;
    static boolean[] isVisited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            graph[i] = new ArrayList<>();
        }
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(finish, cost));
        }

        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];
            dijkstra(i);
        }

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                for (int j = 1; j <= N; j++) {
                    result[j] += dist[X][j];
                }
            } else {
                result[i] += dist[i][X];
            }
        }

        System.out.println(Arrays.stream(result).max().getAsInt());
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        dist[start][start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            isVisited[now.v] = true;

            for (Node next : graph[now.v]) {
                if (!isVisited[next.v] && dist[start][next.v] > now.cost + next.cost) {
                    dist[start][next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[start][next.v]));
                }
            }
        }
    }
}
