
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] boxes = new int[num + 1];
        int[] dp = new int[num + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= num; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                if (boxes[j] < boxes[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt() + 1);
    }
}
