import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_INT = 98754321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        int[][] map = new int[city + 1][city + 1];
        StringTokenizer st;

        int value;
        for (int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                value = MAX_INT;
                if (i == j) {
                    value = 0;
                }
                map[i][j] = value;
            }
        }

        //중복 -> 더 작은 비용 선택
        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], Integer.parseInt(st.nextToken()));
        }

        for (int k = 1; k <= city; k++) {
            for (int a = 1; a <= city; a++) {
                for (int b = 1; b <= city; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a = 1; a <= city; a++) {
            for (int b = 1; b <= city; b++) {
                int res = map[a][b];
                if (res == MAX_INT) {
                    res = 0;
                }
                sb.append(res);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}