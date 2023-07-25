import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = getMaxSum(num, arr);
        System.out.println(max);
        br.close();
    }
    static int getMaxSum(int n, int[] arr) {
        int[] dpSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dpSum[i] = arr[i - 1];
            for (int j = 1; j < i; j++) {
                if (arr[i - 1] > arr[j - 1]) {
                    dpSum[i] = Math.max(dpSum[i], dpSum[j] + arr[i - 1]);
                }
            }
        }
        return Arrays.stream(dpSum).max().getAsInt();
    }
}
