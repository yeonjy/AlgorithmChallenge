import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= 10; k++) {
            // 초기화
            int tc = Integer.parseInt(br.readLine());
            map = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = line.charAt(j);
                }
            }
            int result = findMax();

            sb.append("#" + tc + " ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int findMax() {
        for (int n = 100; n > 1; n--) {
            // 열 탐색
            for (int x = 0; x < 100 - n + 1; x++) {
                for (int y = 0; y < 100; y++) {
                    boolean rowSuccess = true;
                    for (int k = 0; k < n / 2; k++) {
                        if (map[x + k][y] != map[x + n - k - 1][y]) {
                            rowSuccess = false;
                            break;
                        }
                    }
                    if (rowSuccess) {
                        return n;
                    }
                }
            }
            // 행 탐색
            for (int x = 0; x < 100; x++) {
                for (int y = 0; y < 100 - n + 1; y++) {
                    boolean colSuccess = true;
                    for (int k = 0; k < n / 2; k++) {
                        if (map[x][y + k] != map[x][y + n - k - 1]) {
                            colSuccess = false;
                            break;
                        }
                    }
                    if (colSuccess) {
                        return n;
                    }
                }
            }
        }
        return 1;
    }
}
