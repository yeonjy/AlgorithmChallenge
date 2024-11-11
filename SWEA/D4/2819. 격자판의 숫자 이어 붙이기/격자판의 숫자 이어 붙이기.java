import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static final int[] dx = new int[]{0, 0, -1, 1};
    static final int[] dy = new int[]{-1, 1, 0, 0};
    static String[][] map;
    static String now;
    static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            map = new String[4][4];
            result = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    map[i][j] = st.nextToken();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    now = map[i][j];
                    dfs(i, j);
                }
            }
            sb.append("#" + tc + " " + result.size() + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        if (now.length() == 7) {
            result.add(now);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (isValid(nX, nY)) {
                now += map[nX][nY];
                dfs(nX, nY);
                now = now.substring(0, now.length() - 1);
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < 4 && y < 4;
    }
}
