import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{0, 0, 1, -1};
    static final int[] dy = new int[]{1, -1, 0, 0};

    static int N;
    static int M;
    static boolean[][] isVisited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1][M + 1];
        map = new int[N + 1][M + 1];
        int[][] trashes = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trashes[i] = new int[]{x, y};
            map[x][y] = 1;
        }

        int max = 1;
        for (int i = 0; i < K; i++) {
            int[] trash = trashes[i];

            if (!isVisited[trash[0]][trash[1]]) {
                max = Math.max(max, bfs(trash));
            }
        }
        System.out.println(max);
    }

    static int bfs(int[] loc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(loc);
        int size = 0;
        isVisited[loc[0]][loc[1]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (isValid(nextX, nextY) && !isVisited[nextX][nextY] && map[nextX][nextY] == 1) {
                    isVisited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
        return size;
    }

    static boolean isValid(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= M;
    }
}

