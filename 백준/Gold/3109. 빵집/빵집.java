import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{-1, 0, 1};
    static int R;
    static int C;
    static boolean[][] map;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = tokens[j].equals(".");
            }
        }

        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean dfs(int x, int y) {
        map[x][y] = false;
        if (y == C - 1) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i];
            if (isValid(nextX, y + 1) && dfs(nextX, y + 1)) {
                return true;
            }
        }
        return false;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y < C && map[x][y];
    }

}
