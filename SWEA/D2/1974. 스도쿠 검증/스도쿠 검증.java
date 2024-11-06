import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int[] sd = {0, 3, 6};

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // map 초기화
            map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = check();
            sb.append("#" + tc + " " + res + "\n");
        }
        System.out.println(sb);
    }

    static int check() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkSquare(sd[i], sd[j])) {
                    return 0;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!checkLine(i)) {
                return 0;
            }
        }
        return 1;
    }

    static boolean checkSquare(int x, int y) {
        boolean[] exist = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (exist[map[x + i][y + j]]) {
                    return false;
                }
                exist[map[x + i][y + j]] = true;
            }
        }
        return true;
    }

    static boolean checkLine(int n) {
        boolean[] existRow = new boolean[10];
        boolean[] existCol = new boolean[10];

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (existRow[map[i][n]]) {
                return false;
            }
            if (existCol[map[n][i]]) {
                return false;
            }
            existRow[map[i][n]] = true;
            existCol[map[n][i]] = true;
        }
        return true;
    }
}
