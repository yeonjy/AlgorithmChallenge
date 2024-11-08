import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static final Integer ONE = 1;
    static final int[][] nums = new int[][]{
            {0, 0, 0, 1, 1, 0, 1},
            {0, 0, 1, 1, 0, 0, 1},
            {0, 0, 1, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 1, 1},
            {0, 1, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1},
            {0, 1, 1, 0, 1, 1, 1},
            {0, 0, 0, 1, 0, 1, 1}
    };

    static int[][] map;
    static int[] password;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            int res = checkTrue();

            sb.append("#" + tc + " " + res + "\n");
        }
        System.out.println(sb);
    }

    static int checkTrue() {
        int[] last = findOneInLine();
        int x = last[0];
        int y = last[1];
        password = new int[56];
        int idx = -1;
        for (int i = 55; i >= 0; i--) {
            password[++idx] = map[x][y - i];
        }

        int[] tenPassword = new int[8];
        for (int i = 0; i < 56; i += 7) {
            tenPassword[i / 7] = getTenNum(i);
        }

        return getResult(tenPassword);
    }

    static int[] findOneInLine() {
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                if (map[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    static int getTenNum(int start) {
        boolean flag;
        for (int i = 0; i < 10; i++) {  // 0 ~ 9
            flag = true;
            for (int j = 0; j < 7; j++) {
                if (password[start + j] != nums[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return 10;
    }

    static int getResult(int[] pw) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {  // index가 짝수일때
                even += pw[i];
            } else {  // 홀수일때
                odd += pw[i];
            }
        }

        if ((even * 3 + odd) % 10 == 0) {
            return even + odd;
        } else {
            return 0;
        }
    }
}
