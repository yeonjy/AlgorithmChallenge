import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int N;
    static int M;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] isVisited;
    static int start;
    static int dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int inputU = Integer.parseInt(st.nextToken());
            int inputV = Integer.parseInt(st.nextToken());
            int inputCost = Integer.parseInt(st.nextToken());
            graph[inputU].add(new Node(inputV, inputCost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[dest]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (!isVisited[now.v]) {
                isVisited[now.v] = true;

                for (Node next : graph[now.v]) {
                    if (!isVisited[next.v] && dist[next.v] > dist[now.v] + next.cost) {
                        dist[next.v] = dist[now.v] + next.cost;
                        q.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
    }
}
