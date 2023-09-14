import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[][] map = new int[9][9];
    static boolean success;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        backtracking(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void backtracking(int depth) {
        if (depth == 81) {
            success = true;
            return;
        }

        int x = depth / 9;
        int y = depth % 9;
        if (map[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(x, y, i)) {
                    map[x][y] = i;
                    backtracking(depth + 1);
                    if (success) {
                        return;
                    }
                    map[x][y] = 0;
                }
            }
        } else {
            backtracking(depth + 1);
        }
    }

    static boolean isValid(int x, int y, int n) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == n || map[i][y] == n) {
                return false;
            }
        }

        int checkX = x / 3 * 3;
        int checkY = y / 3 * 3;
        for (int i = checkX; i < checkX + 3; i++) {
            for (int j = checkY; j < checkY + 3; j++) {
                if (map[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }
}
