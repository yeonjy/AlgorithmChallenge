import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int min;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Math.min(N, M) / 2;
        for (int i = 0; i < min; i++) {
            int cnt = R % (((N - 2 * i) + (M - 2 * i)) * 2 - 4);
            rotate(i, cnt);
        }
        System.out.println(print());
    }

    static void rotate(int idx, int cnt) {
        for (int r = 0; r < cnt; r++) {

            int x = idx;
            int y = idx;
            int tmp = map[y][x];

            int dir = 0;

            while (dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < idx || ny < idx || nx >= M - idx || ny >= N - idx) {
                    dir++;
                    continue;
                }

                map[y][x] = map[ny][nx];
                y = ny;
                x = nx;
            }
            map[idx + 1][idx] = tmp;
        }
    }

    static StringBuilder print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }
}
