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

    static int N;
    static int[] dist;
    static ArrayList<Node>[] graph;
    static ArrayList<Integer>[] routes;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        routes = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
            routes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(finish, time));
            graph[finish].add(new Node(start, time));
        }

        dijkstraRoute();
        ArrayList<Integer> route = routes[N];
        int time = dist[N];
        int max = 0;

        for (int i = 1; i < route.size(); i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            isVisited = new boolean[N + 1];
            int start = route.get(i - 1);
            int finish = route.get(i);
            int cost = 0;
            for (Node node : graph[start]) {
                if (node.v == finish) {
                    cost = node.cost;
                    graph[start].remove(node);
                    graph[finish].remove(new Node(start, node.cost));
                    break;
                }
            }
            dijkstra();
            graph[start].add(new Node(finish, cost));
            graph[finish].add(new Node(start, cost));

            max = Math.max(max, dist[N]);
        }

        if (max == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(max - time);
    }

    static void dijkstraRoute() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(1, 0));
        dist[1] = 0;
        routes[1].add(1);

        while (!q.isEmpty()) {
            Node now = q.poll();
            isVisited[now.v] = true;

            for (Node next : graph[now.v]) {
                if (!isVisited[next.v] && dist[next.v] > now.cost + next.cost) {
                    routes[next.v] = (ArrayList<Integer>) routes[now.v].clone();
                    routes[next.v].add(next.v);
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(1, 0));
        dist[1] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            isVisited[now.v] = true;

            for (Node next : graph[now.v]) {
                if (!isVisited[next.v] && dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
