import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long start = 0;
        long end = arr[N - 1];
        long mid = (start + end) / 2;
        while (start <= end) {
            long tree = getTreeNum(mid);
            if (tree < M) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else if (tree > M) {
                start = mid + 1;
                mid = (start + end) / 2;
            } else {
                break;
            }
        }
        System.out.println(mid);
    }

    static long getTreeNum(long mid) {
        long res = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > mid) {
                res += arr[i] - mid;
            }
        }
        return res;
    }
}
