import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][3];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res;
        if (num > 1) {
            res = calculate(arr);
        } else {
            res = Arrays.stream(arr[0]).min().getAsInt();
        }

        System.out.println(res);
    }

    static int calculate(int[][] arr) {
        int len = arr.length;
        int[] minOfLast = new int[3];

        //red
        int[][] dp = new int[len][3];
        dp[1][0] = 2002;
        dp[1][1] = arr[1][1] + arr[0][0];
        dp[1][2] = arr[1][2] + arr[0][0];

        getMin(dp, arr);
        minOfLast[0] = Math.min(dp[len - 1][1], dp[len - 1][2]);

        //green
        dp = new int[len][3];
        dp[1][0] = arr[1][0] + arr[0][1];
        dp[1][1] = 2002;
        dp[1][2] = arr[1][2] + arr[0][1];
        getMin(dp, arr);
        minOfLast[1] = Math.min(dp[len - 1][0], dp[len - 1][2]);

        //blue
        dp = new int[len][3];
        dp[1][0] = arr[1][0] + arr[0][2];
        dp[1][1] = arr[1][1] + arr[0][2];
        dp[1][2] = 2002;
        getMin(dp, arr);
        minOfLast[2] = Math.min(dp[len - 1][0], dp[len - 1][1]);

        return Arrays.stream(minOfLast).min().getAsInt();
    }

    static void getMin(int[][] dp, int[][] arr) {
        int len = arr.length;
        for (int i = 2; i < len; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
    }
}

