import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int t;
        int p;

        public Node(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int nowMax = 0;
        for (int i = 0; i < N; i++) {
            if (nowMax < dp[i]) {
                nowMax = Math.max(nowMax, dp[i]);
            }
            int time = i + arr[i].t;
            if (time > N) {
                continue;
            }
            dp[time] = Math.max(dp[time], nowMax + arr[i].p);
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
