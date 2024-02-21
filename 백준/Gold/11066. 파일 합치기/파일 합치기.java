import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            int size = Integer.parseInt(br.readLine());
            int[] files = new int[size + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < size + 1; j++) {
                files[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(getResult(size, files)).append("\n");
        }
        System.out.println(sb);
    }

    static long getResult(int size, int[] files) {
        int[][] dp = new int[size + 1][size + 1];
        int[] sum = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            sum[i] = sum[i - 1] + files[i];
        }

        for (int gap = 1; gap <= size; gap++) {
            for (int from = 1; from <= size - gap; from++) {
                int to = from + gap;
                dp[from][to] = Integer.MAX_VALUE;
                for (int n = from; n < to; n++) {
                    dp[from][to] = Math.min(dp[from][to], dp[from][n] + dp[n + 1][to] + sum[to] - sum[from - 1]);
                }
            }
        }
        return dp[1][size];
    }
}
