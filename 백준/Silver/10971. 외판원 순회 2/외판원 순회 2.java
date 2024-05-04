import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int start;
    static int[][] map;
    static boolean[] isVisited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            start = i;
            backtracking(i, 0, 0);
        }
        System.out.println(result);

    }

    static void backtracking(int now, int cost, int cnt) {
        if (cost >= result) {
            return;
        }

        if (now == start && cnt == N) {
            result = cost;
        }

        for (int i = 0; i < N; i++) {
            if (map[now][i] == 0 || isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            backtracking(i, cost + map[now][i], cnt + 1);
            isVisited[i] = false;
        }
    }
}
