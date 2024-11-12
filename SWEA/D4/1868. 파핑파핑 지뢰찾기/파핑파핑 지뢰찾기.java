import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};  // 시계방향
    static final int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};  // 시계방향

    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            int res = 0;

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            boolean isZero;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    isZero = true;
                    if (map[i][j] == '.') {
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (isValid(nx, ny) && map[nx][ny] == '*') {
                                isZero = false;
                                break;
                            }
                        }
                        if (isZero) {
                            map[i][j] = '0';
                            move(i, j);
                            res++;
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') {
                        res++;
                    }
                }
            }

            sb.append("#" + tc + " " + res + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny)) {
                if (map[nx][ny] == '*') {
                    cnt++;
                }
            }
        }
        map[x][y] = Character.forDigit(cnt, 10);

        if (cnt == 0) {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isValid(nx, ny) && map[nx][ny] == '.') {
                    dfs(nx, ny);
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static void move(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }
}
