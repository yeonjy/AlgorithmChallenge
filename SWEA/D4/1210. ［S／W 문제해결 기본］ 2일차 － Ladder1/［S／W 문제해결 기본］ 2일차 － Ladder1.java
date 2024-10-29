import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int IMPOSSIBLE = 100;
    static int[][] data;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            data = new int[100][100];
            isVisited = new boolean[100][100];
            br.readLine();
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 100; i++) {
                if (data[99][i] == 2) {
                    isVisited[99][i] = true;
                    sb.append("#" + tc + " ").append(getResult(i)).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static int getResult(int y) {
        int x = 99;
        while (x != 0) {
            int width = checkWidth(x, y);
            if (width != IMPOSSIBLE) {
                y = width;
                isVisited[x][y] = true;
                continue;
            }
            if (data[x - 1][y] == 1) {
                x--;
                isVisited[x][y] = true;
            }

        }

        for (int i = 0; i < 100; i++) {
            if (isVisited[0][i]) {
                return i;
            }
        }
        return IMPOSSIBLE;
    }

    static int checkWidth(int x, int y) {
        if (y - 1 >= 0 && !isVisited[x][y - 1] && data[x][y - 1] == 1) {
            return y - 1;
        }
        if (y + 1 < 100 && !isVisited[x][y + 1] && data[x][y + 1] == 1) {
            return y + 1;
        }
        return IMPOSSIBLE;
    }
}
