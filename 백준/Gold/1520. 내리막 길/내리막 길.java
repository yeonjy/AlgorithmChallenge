import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static int M;
    static int N;
    static int[][] map;
    static int[][] dp;
    static boolean[][] isVisited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        isVisited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {  //첫 방문인지 확인하는 이유: 이미 방문한 곳이면 (x, y)에서
            return dp[x][y];   //도착지까지 가는 경로 탐색한 곳이기 때문
        }
        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValid(nextX, nextY) && (map[x][y] > map[nextX][nextY])) {
                dp[x][y] += dfs(nextX, nextY);
            }
        }
        return dp[x][y];
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
