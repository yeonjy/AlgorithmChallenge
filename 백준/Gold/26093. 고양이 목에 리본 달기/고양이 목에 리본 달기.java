import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[][] ribons = new Integer[N][K];
        Integer[][] dp = new Integer[N][K];

        // 리본 선호도 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                ribons[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫번째 고양이의 리본 선호도를 dp 배열에 저장
        dp[0] = ribons[0].clone();

        for (int i = 1; i < N; i++) {
            // 이전 dp 배열에서 최대값과 두번째 최대값을 찾음
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            for (int j = 0; j < K; j++) {
                if (dp[i - 1][j] > max1) {
                    max2 = max1;
                    max1 = dp[i - 1][j];
                } else if (dp[i - 1][j] > max2) {
                    max2 = dp[i - 1][j];
                }
            }

            // 현재 고양이의 dp 배열을 갱신
            for (int j = 0; j < K; j++) {
                if (dp[i - 1][j].equals(max1)) {
                    dp[i][j] = ribons[i][j] + max2;
                } else {
                    dp[i][j] = ribons[i][j] + max1;
                }
            }
        }

        // 마지막 고양이의 dp 배열에서 최대값을 찾음
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < K; j++) {
            if (dp[N - 1][j] > max) {
                max = dp[N - 1][j];
            }
        }
        System.out.println(max);
    }
}
