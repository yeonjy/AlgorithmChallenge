import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] map;
    static int[][] costMap;

    public static void main(String[] args) throws IOException {
        // input ...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        costMap = new int[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
                costMap[i][j] = Integer.MAX_VALUE;
            }
        }

        // algorithm
        costMap[0][0] = 0;
        bfs();
        System.out.println(costMap[M - 1][N - 1]);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowCost = costMap[now[0]][now[1]];
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (isValid(nextX, nextY)) {
                    // 벽일때
                    if (map[nextX][nextY] == 1 && costMap[nextX][nextY] > nowCost + 1) {
                        costMap[nextX][nextY] = nowCost + 1;
                        queue.add(new int[]{nextX, nextY});
                    // 벽이 아닐 때
                    } else if (map[nextX][nextY] == 0 && costMap[nextX][nextY] > nowCost) {
                        costMap[nextX][nextY] = nowCost;
                        queue.add(new int[]{nextX, nextY});
                    }
                }

            }

        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}
