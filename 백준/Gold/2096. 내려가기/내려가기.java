import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int[] direc = new int[]{-1, 0, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] dp = new int[N][3];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0] = map[0].clone();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int nextX = i + 1;
                    int nextY = j + direc[k];
                    if (isValid(nextY) && dp[nextX][nextY] < dp[i][j] + map[nextX][nextY]) {
                        dp[nextX][nextY] = dp[i][j] + map[nextX][nextY];
                    }
                }
            }
        }
        sb.append(Arrays.stream(dp[N - 1]).max().getAsInt()).append(" ");

        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0] = map[0].clone();
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int nextX = i + 1;
                    int nextY = j + direc[k];
                    if (isValid(nextY) && dp[nextX][nextY] > dp[i][j] + map[nextX][nextY]) {
                        dp[nextX][nextY] = dp[i][j] + map[nextX][nextY];
                    }
                }
            }
        }
        sb.append(Arrays.stream(dp[N - 1]).min().getAsInt());
        System.out.println(sb);
    }

    static boolean isValid(int idx) {
        return idx >= 0 && idx < 3;
    }
}
