import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            long[][] map = new long[2][n];
            long[][] dp = new long[2][n];

            for (int x = 0; x < 2; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < n; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];

            if (n > 1) {
                dp[0][1] = dp[1][0] + map[0][1];
                dp[1][1] = dp[0][0] + map[1][1];
            }

            for (int num = 2; num < n; num++) {
                dp[0][num] = Math.max(dp[1][num - 1], dp[1][num - 2]) + map[0][num];
                dp[1][num] = Math.max(dp[0][num - 1], dp[0][num - 2]) + map[1][num];
            }
            
            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}
