import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int min;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

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
        min = Math.min(N, M);
        for (int i = 1; i <= R; i++) {
            rotate();
        }
        System.out.println(print());
    }

    static void rotate() {
        for (int t = 0; t < min / 2; t++) {  // 회전시킬 네모의 개수
            int x = t;
            int y = t;
            int temp = map[x][y];  // 마지막에 넣을 값
            int idx = 0;
            while (idx < 4) {  // 반시계 방향으로 회전
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 범위 안이라면
                if (nx < N - t && ny < M - t && nx >= t && ny >= t) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    idx++;  // 방향 전환
                }
            }
            map[t + 1][t] = temp;  // 시작했던 값 끝에 넣어주기
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
