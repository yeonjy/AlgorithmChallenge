import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {  //test case는 10개
            N = Integer.parseInt(br.readLine());
            buildings = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            sb.append("#" + tc + " ").append(getResult()).append("\n");
        }
        System.out.println(sb);
    }
    static int getResult() {
        int result = 0;
        for (int i = 2; i < N - 2; i++) {
            int leftMax = Math.max(buildings[i - 2], buildings[i - 1]);
            int rightMax = Math.max(buildings[i + 1], buildings[i + 2]);
            int res = buildings[i] - Math.max(leftMax, rightMax);
            if (res > 0) {
                result += res;
            }
        }
        return result;
    }
}
