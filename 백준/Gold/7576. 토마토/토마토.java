import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[][] map;
    static boolean[][] isVisited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m];

        List<int[]> ripenLoaction = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int status = Integer.parseInt(st.nextToken());
                if (status == 1) {
                    ripenLoaction.add(new int[] {i, j});
                }
                map[i][j] = status;
            }
        }
        bfs(ripenLoaction);

        System.out.println(getResult());

    }

    static void bfs(List<int[]> param) {
        Queue<int[]> queue = new LinkedList<>(param);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (isValid(nextX, nextY)) {
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }

        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 0;
    }

    static int getResult() {
        int max = 0;
        if (isZero()) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }
            return max - 1;
        }
    }

    static boolean isZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
