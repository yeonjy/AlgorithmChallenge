import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int finalLeft = 0;
        int finalRight = 0;
        int left = 0;
        int right = N - 1;
        long sum = Long.MAX_VALUE;

        while (right > left) {
            int test = arr[right] + arr[left];
            //test 가 더 작다면 sum update
            if (sum > Math.abs(test)) {
                sum = Math.abs(test);
                finalLeft = left;
                finalRight = right;
            }

            if (test > 0) {  //합이 양수일 때: right--
                right--;
            } else {  //합이 음수거나 0일 때: left++;
                left++;
            }
        }
        System.out.println(arr[finalLeft] + " " + arr[finalRight]);
    }
}
