import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];
        int[] coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        coins = Arrays.stream(coins).distinct().toArray();  //중복 제거
        Arrays.sort(coins);

        for(int coin : coins) {
            calculate(coin);
        }
        checkPresent();

        System.out.println(dp[K]);
    }
    static void calculate(int coin) {
        if(coin <= K) {
            dp[coin] = 1;
        }
        for(int i = coin + 1; i <= K; i++) {
            if(dp[i-coin] != 0) {
                if(dp[i] == 0) {
                    dp[i] = dp[i - coin] + 1;
                }
                else {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
    }

    static void checkPresent() {
        if(dp[K] == 0) {
            dp[K] = -1;
        }
    }
}
