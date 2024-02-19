import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};

    static int N;
    static int M;
    static String[][] map;
    static int[][] timeMap;
    static boolean[][] isVisited;
    static int maxTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        //map 입력받기
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("L")) {
                    isVisited = new boolean[N][M];
                    initTimeMap();
                    bfs(i, j);
                }
            }
        }
        System.out.println(maxTime);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int time = now[2];
            isVisited[nowX][nowY] = true;
            if (time > maxTime) {
                maxTime = time;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (isValid(nextX, nextY) && !isVisited[nextX][nextY] && map[nextX][nextY].equals("L")) {
                    isVisited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY, time + 1});
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static void initTimeMap() {
        timeMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                timeMap[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
