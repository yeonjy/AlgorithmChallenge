import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1_000_000_009;
        }

        for (int num : nums) {
            sb.append((dp[num][1] + dp[num][2] + dp[num][3]) % 1_000_000_009).append("\n");
        }
        System.out.println(sb);
    }
}
