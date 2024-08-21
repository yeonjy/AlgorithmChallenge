import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int max;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j+ 1);
                    max = Math.max(max, checkRowMax(i));
                    max = Math.max(max, checkColMax(j));
                    max = Math.max(max, checkColMax(j + 1));
                    swap(i, j, i, j + 1);
                }
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, checkRowMax(i));
                    max = Math.max(max, checkRowMax(i + 1));
                    max = Math.max(max, checkColMax(j));
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(max);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char tmp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = tmp;
    }

    private static int checkRowMax(int x) {
        int tmp = 1;
        int result = 1;
        char ch = map[x][0];
        for (int i = 1; i < N; i++) {
            if (map[x][i] != ch) {
                ch = map[x][i];
                result = Math.max(result, tmp);
                tmp = 1;
            } else {
                tmp++;
            }
        }
        return Math.max(result, tmp);
    }

    private static int checkColMax(int y) {
        int tmp = 1;
        int result = 1;
        char ch = map[0][y];
        for (int i = 1; i < N; i++) {
            if (map[i][y] != ch) {
                ch = map[i][y];
                result = Math.max(result, tmp);
                tmp = 1;
            } else {
                tmp++;
            }
        }
        return Math.max(result, tmp);
    }
}
