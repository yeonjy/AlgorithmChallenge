import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static int q;
    static int[][][] map;
    static int[] dx = new int[]{0, 0, -1, 1, 0, 0};
    static int[] dy = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        map = new int[q][n][m];

        //토마토 상태 입력
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        queue.add(new int[] {i, j, k});
                    }
                    map[i][j][k] = num;
                }
            }
        }

        bfs(queue);
        System.out.println(getResult());
    }

    static void bfs(Queue<int[]> param) {
        Queue<int[]> queue = new LinkedList<>(param);

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowZ = now[2];

            for (int i = 0; i < 6; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                int nextZ = nowZ + dz[i];

                if (isValid(nextX, nextY, nextZ)) {
                    map[nextX][nextY][nextZ] = map[nowX][nowY][nowZ] + 1;
                    queue.add(new int[]{nextX, nextY, nextZ});
                }
            }
        }
    }

    static boolean isValid(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < q && y < n && z < m && map[x][y][z] == 0;
    }

    static int getResult() {
        int max = 0;

        for (int i = 0; i < q; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int test = map[i][j][k];
                    if (test == 0) {
                        return -1;
                    } else if (test > max) {
                        max = test;
                    }
                }
            }
        }
        return max - 1;
    }
}
