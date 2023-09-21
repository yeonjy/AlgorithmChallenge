import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
            }
        }

        dfs(N, 0, 0);
        System.out.println(sb);
    }

    static void dfs(int range, int x, int y) {
        if (isEqualCheck(range, x, y)) {
            sb.append(map[x][y]);
            return;
        }

        sb.append("(");
        dfs(range / 2, x, y);
        dfs(range / 2, x, y + range / 2);
        dfs(range / 2, x + range / 2, y);
        dfs(range / 2, x + range / 2, y + range / 2);
        sb.append(")");
    }

    static boolean isEqualCheck(int range, int x, int y) {
        int num = map[x][y];
        for (int i = x; i < x + range; i++) {
            for (int j = y; j < y + range; j++) {
                if (map[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
