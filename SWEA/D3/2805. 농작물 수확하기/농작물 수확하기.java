import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            // map 초기화
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            int sum = 0;
            for (int i = 0; i <= N / 2; i++) {
                for (int j = N / 2 - i; j <= N / 2 + i; j++) {
                    sum += map[i][j];
                }
            }

            for (int i = N - 1; i > N / 2; i--) {
                for (int j = N / 2 - N + i + 1; j <= N / 2 + N - i - 1; j++) {
                    sum += map[i][j];
                }
            }

            sb.append("#" + tc + " " + sum + "\n");
        }
        System.out.println(sb);
    }
}
