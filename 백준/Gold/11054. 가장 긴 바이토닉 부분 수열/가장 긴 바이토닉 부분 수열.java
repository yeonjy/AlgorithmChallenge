import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bitonic());
    }

    static int bitonic() {
        int[] dp = new int[arr.length + 1];
        int[] increaseDp = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i - 1] > arr[j - 1]) {
                    increaseDp[i] = Math.max(increaseDp[i], increaseDp[j] + 1);
                }
            }
            int[] tmpArr = Arrays.copyOfRange(arr, i - 1, arr.length);
            int decrease = decrease(tmpArr);
            dp[i] = increaseDp[i] + decrease;
        }
        return Arrays.stream(dp).max().getAsInt() + 1;
    }

    static int decrease(int[] newArr) {
        int[] reversedArr = new int[newArr.length];
        for (int i = newArr.length - 1, j = 0; i >= 0; i--, j++) {
            reversedArr[j] = newArr[i];
        }
        int[] dp = new int[reversedArr.length + 1];

        for (int i = 1; i <= reversedArr.length; i++) {
            for (int j = 1; j < i; j++) {
                if (reversedArr[i - 1] > reversedArr[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[reversedArr.length];
    }
}
