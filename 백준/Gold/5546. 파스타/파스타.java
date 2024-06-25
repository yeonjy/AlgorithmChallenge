import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] plan = new int[N + 1];
        int[][][] dp = new int[N + 1][2][3];
        // 파스타 계획 저장
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int pasta = Integer.parseInt(st.nextToken());
            plan[day] = pasta;
        }

        // 첫째날 초기화
        if (plan[1] == 1) {
            dp[1][0] = new int[]{1, 0, 0};
        } else if (plan[1] == 2) {
            dp[1][0] = new int[]{0, 1, 0};
        } else if (plan[1] == 3) {
            dp[1][0] = new int[]{0, 0, 1};
        } else {
            dp[1][0] = new int[]{1, 1, 1};
        }

        for (int i = 2; i < N + 1; i++) {
            if (plan[i] == 1) {
                dp[i][0][0] = (dp[i - 1][0][1] + dp[i - 1][1][1] + dp[i - 1][0][2] + dp[i - 1][1][2]) % 10000;
                dp[i][1][0] = dp[i - 1][0][0];
            } else if (plan[i] == 2) {
                dp[i][0][1] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][0][2] + dp[i - 1][1][2]) % 10000;
                dp[i][1][1] = dp[i - 1][0][1];
            } else if (plan[i] == 3) {
                dp[i][0][2] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][0][1] + dp[i - 1][1][1]) % 10000;
                dp[i][1][2] = dp[i - 1][0][2];
            } else {
                dp[i][0][0] = (dp[i - 1][0][1] + dp[i - 1][1][1] + dp[i - 1][0][2] + dp[i - 1][1][2]) % 10000;
                dp[i][1][0] = dp[i - 1][0][0];
                dp[i][0][1] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][0][2] + dp[i - 1][1][2]) % 10000;
                dp[i][1][1] = dp[i - 1][0][1];
                dp[i][0][2] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][0][1] + dp[i - 1][1][1]) % 10000;
                dp[i][1][2] = dp[i - 1][0][2];
            }
        }

        int result = (Arrays.stream(dp[N][0]).sum() + Arrays.stream(dp[N][1]).sum()) % 10000;
        System.out.println(result);
    }
}
