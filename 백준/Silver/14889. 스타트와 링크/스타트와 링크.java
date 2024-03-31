import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] isVisited;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = Integer.MAX_VALUE;

        dfs(0, 1);
        System.out.println(result);
    }

    static void dfs(int depth, int now) {
        if (depth == N / 2) {
            result = Math.min(result, getDifference() / 2);
            return;
        }

        for (int i = now; i <= N; i++) {
            isVisited[i] = true;
            dfs(depth + 1, i + 1);
            isVisited[i] = false;
        }
    }

    static int getDifference() {
        int right = 0;
        int left = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!isVisited[i] && !isVisited[j]) {
                    right = right + map[i][j] + map[j][i];
                }
                 else if (isVisited[i] && isVisited[j]) {
                    left = left + map[i][j] + map[j][i];
                }
            }
        }
        return Math.abs(right - left);
    }

}
