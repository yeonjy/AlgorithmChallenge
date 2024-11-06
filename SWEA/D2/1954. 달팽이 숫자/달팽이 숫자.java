import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[][] map;
    static int N;
    static int square;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            num = 1;

            for (square = 0; square < N / 2; square++) {
                right(square, square);
            }
            if (N % 2 == 1) {
                map[N / 2][N / 2] = N * N;
            }
            
            sb.append("#" + tc + "\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void right(int x, int y) {
        while (x != square || y != N - square - 1) {
            map[x][y++] = num++;
        }
        down(x, y);
    }
    static void down(int x, int y) {
        while (x != N - square - 1 || y != N - square - 1) {
            map[x++][y] = num++;
        }
        left(x, y);
    }
    static void left(int x, int y) {
        while (x != N - square - 1 || y != square) {
            map[x][y--] = num++;
        }
        up(x, y);
    }
    static void up(int x, int y) {
        while (x != square || y != square) {
            map[x--][y] = num++;
        }
    }

}
