import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] indegree;
    static boolean[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            N = Integer.parseInt(br.readLine());
            indegree = new int[N + 1];
            edges = new boolean[N + 1][N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                indegree[num] = i;

                for (int j = 1; j <= N; j++) {
                    if (j != num && !edges[j][num]) {
                        edges[num][j] = true;
                    }
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                swap(n1, n2);
            }
            System.out.println(topologicalSort());
        }
    }

    private static void swap(int n1, int n2) {
        if (!edges[n1][n2]) {
            edges[n1][n2] = true;
            edges[n2][n1] = false;
            indegree[n1]--;
            indegree[n2]++;
        } else {
            edges[n1][n2] = false;
            edges[n2][n1] = true;
            indegree[n1]++;
            indegree[n2]--;
        }
    }

    private static String topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (queue.size() == 0) {
                return "IMPOSSIBLE";
            }

            if (queue.size() > 1) {
                return "?";
            }

            int cur = queue.poll();
            sb.append(cur + " ");

            for (int j = 1; j <= N; j++) {
                if (edges[cur][j]) {
                    edges[cur][j] = false;
                    if (--indegree[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }
        return sb.toString();
    }

}
