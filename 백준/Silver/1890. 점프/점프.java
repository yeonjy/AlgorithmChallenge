import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int ZERO = 0;
    static final int ONE = 1;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];

        //게임판에 적혀있는 수 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[ZERO][ZERO] = ONE;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (dp[x][y] > ZERO) {
                    int jump = map[x][y];
                    if (jump > 0) {
                        if (isValid(x + jump, y)) {
                            dp[x + jump][y] += dp[x][y];
                        }

                        if (isValid(x, y + jump)) {
                            dp[x][y + jump] += dp[x][y];
                        }
                    }
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }

    static boolean isValid(int x, int y) {
        return x < N && y < N;
    }
}