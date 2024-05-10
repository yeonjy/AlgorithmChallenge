import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int v;
        int weight;

        Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N;
    static int D;
    static int[] distance;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        distance = new int[10001];
        graph = new List[10001];

        for (int i = 0; i < graph.length; i++) {
            distance[i] = i;
            graph[i] = new ArrayList<>();
        }

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, d));
        }
        dijkstra(0);

        System.out.println(distance[D]);
    }

    private static void dijkstra(int start) {
        if (start > D) {
            return;
        }
        if (distance[start + 1] > distance[start] + 1) {
            distance[start + 1] = distance[start] + 1;
        }

        for (Node next : graph[start]) {
            if (distance[start] + next.weight < distance[next.v]) {
                distance[next.v] = distance[start] + next.weight;
            }
        }
        dijkstra(start + 1);
    }
}