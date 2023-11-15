import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] snow = new int[n];
        IntStream.range(0, n).forEach(i -> snow[i] = Integer.parseInt(st.nextToken()));
        Arrays.sort(snow);
        long ans = getAns(n, snow);
        System.out.println(ans);

    }

    private static long getAns(int n, int[] snow) {
        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 3; j < n; j++) {
                int one = snow[i] + snow[j];
                int l = i + 1;
                int r = j - 1;
                while (l <= r) {
                    int two = snow[l] + snow[r];
                    ans = Math.min(ans, Math.abs(one - two));
                    if (one - two <= 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
