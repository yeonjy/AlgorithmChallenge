import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[][] map;
    static int n;
    static int m;
    static List<int[]> virus;
    static int maxZero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        virus = new ArrayList<>();

        //연구소 입력받기 & virus 위치 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) {
                    virus.add(new int[]{i, j});
                }
                map[i][j] = tmp;
            }
        }

        dfs(0);
        System.out.println(maxZero);
    }

    //벽 3개 세우기
    static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>(virus);
        int[][] lab = new int[n][m];

        for (int i = 0 ; i < n; i++) {
            lab[i] = map[i].clone();
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < n && nextY < m && nextX >= 0 && nextY >= 0 && (lab[nextX][nextY] == 0)) {
                    lab[nextX][nextY] = 2;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        getSafeZone(lab);
    }

    static void getSafeZone(int[][] lab) {
        int res = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (lab[x][y] == 0) {
                    res++;
                }
            }
        }
        maxZero = Math.max(maxZero, res);
    }
}
