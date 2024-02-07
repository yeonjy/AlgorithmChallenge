
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{1, -1, 0, 0};
    static final int[] dy = new int[]{0, 0, 1, -1};

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isVisited;
    static int size;
    static int maxSize;

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

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    size = 0;
                    cnt++;
                    dfs(i, j);
                    if (size > maxSize) {
                        maxSize = size;
                    }
                }
            }
        }

        System.out.println(cnt + "\n" + maxSize);
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;
        size++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValid(nextX, nextY) && !isVisited[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && map[x][y] == 1;
    }
}
