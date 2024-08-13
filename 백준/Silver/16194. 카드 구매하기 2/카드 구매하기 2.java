import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (dp[i] > dp[i - j] + dp[j]) {
                    dp[i] = dp[i - j] + dp[j];
                }
            }
        }
        System.out.println(dp[N]);
    }
}
