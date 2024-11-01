import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            if (len == 1) {
                sb.append("#" + tc + " ").append(1).append("\n");
                continue;
            }
            char[][] map = new char[8][8];
            for (int i = 0; i < 8; i++) {
                char[] line = br.readLine().toCharArray();
                map[i] = line.clone();
            }

            int count = 0;
            boolean colFlag;
            boolean rowFlag;
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    colFlag = true;
                    rowFlag = true;
                    for (int n = 0; n < len / 2; n++) {
                        if (y >= 8 - len + 1) {
                            colFlag = false;
                        } else if (map[x][y + n] != map[x][y + len - 1 - n]) {
                            colFlag = false;
                        }
                        if (x >= 8 - len + 1) {
                            rowFlag = false;
                        } else if (map[x + n][y] != map[x + len - 1 - n][y]) {
                            rowFlag = false;
                        }
                    }
                    if (colFlag) {
                        count++;
                    }
                    if (rowFlag) {
                        count++;
                    }
                }
            }

            sb.append("#" + tc + " ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
