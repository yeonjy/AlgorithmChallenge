import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static List<Integer>[] map;
    static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        distances = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
            distances[i] = Integer.MAX_VALUE;
        }
        distances[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start].add(end);
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (distances[i] == K) {
                sb.append(i).append("\n");
            }
        }
        if (sb.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{X, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowCity = now[0];
            int nextDistance = now[1] + 1;

            for (int nextCity : map[nowCity]) {
                if (distances[nextCity] > nextDistance) {
                    distances[nextCity] = nextDistance;
                    q.add(new int[]{nextCity, nextDistance});
                }
            }
        }
    }
}
