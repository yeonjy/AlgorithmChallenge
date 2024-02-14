import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{0, -1, -1};
    static final int[] dy = new int[]{-1, -1, 0};
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        boolean oneExist = false;
        int res = 0;

        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
                if (!oneExist && map[i][j] == 1) {
                    res = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = getLen(i, j) + 1;
                    res = Math.max(res, map[i][j]);
                }
            }
        }
        System.out.println(res * res);

    }

    static int getLen(int x, int y) {
        for (int k = 0; k < 3; k++) {
            if (map[x + dx[k]][y + dy[k]] < 1) {
                return 0;
            }
        }
        return Math.min(map[x][y - 1], Math.min(map[x - 1][y - 1], map[x - 1][y]));
    }
}