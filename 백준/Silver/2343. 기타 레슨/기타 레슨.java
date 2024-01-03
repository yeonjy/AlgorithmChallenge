import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lessons = new int[n];

        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            right += lessons[i];  //총 레슨 시간
            left = Math.max(left, lessons[i]);  //레슨 시간이 가장 긴 레슨
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = getCnt(n, lessons, mid);
            if (cnt > m) {  //구역 수가 m보다 클 때
                left = mid + 1;
            } else {        //구역 수가 m보다 작거나 같을 때
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    private static int getCnt(int n, int[] lessons, int mid) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (sum + lessons[i] > mid) {
                sum = 0;
                cnt++;
            }
            sum += lessons[i];
        }
        if (sum != 0) {
            cnt++;
        }
        return cnt;
    }
}
