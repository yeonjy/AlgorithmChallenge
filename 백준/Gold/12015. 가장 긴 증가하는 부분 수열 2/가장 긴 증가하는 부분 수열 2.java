import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = arr[0];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (dp[cnt - 1] < arr[i]) {
                dp[++cnt - 1] = arr[i];
            } else {
                int left = 0;
                int right = cnt;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (dp[mid] < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = arr[i];
            }
        }
        System.out.println(cnt);
    }
}
