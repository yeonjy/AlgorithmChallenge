
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int p1 = 0;
        int p2 = n - 1;
        int cnt = 0;
        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];
            if (sum == x) {
                cnt++;
                p1++;
                p2--;
            } else if (sum > x) {
                p2--;
            } else {
                p1++;
            }

        }
        System.out.println(cnt);
    }
}
