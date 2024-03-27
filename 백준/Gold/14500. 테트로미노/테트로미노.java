import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isVisited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                bruteforce(i, j, 1, map[i][j]);
                isVisited[i][j] = false;
            }
        }
        System.out.println(result);
    }

    static void bruteforce(int x, int y, int cnt, int cost) {
        if (cnt >= 4) {
            result = Math.max(result, cost);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValid(nextX, nextY) && !isVisited[nextX][nextY]) {
                isVisited[nextX][nextY] = true;
                bruteforce(nextX, nextY, cnt + 1, cost + map[nextX][nextY]);
                isVisited[nextX][nextY] = false;
            }
        }

        if (cnt == 2) {
            int nx1 = x + dx[0];
            int nx2 = x + dx[1];
            if (isValid(nx1, y) && isValid(nx2, y) && !isVisited[nx1][y] && !isVisited[nx2][y]) {
                result = Math.max(result, cost + map[nx1][y] + map[nx2][y]);
                return;
            }

            int ny1 = y + dy[2];
            int ny2 = y + dy[3];
            if (isValid(x, ny1) && isValid(x, ny2) && !isVisited[x][ny1] && !isVisited[x][ny2]) {
                result = Math.max(result, cost + map[x][ny1] + map[x][ny2]);
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
