import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());

        int[][] map = new int[num + 1][num + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int k = 1; k <= num; k++) {
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= num; j++) {
                    int test = map[i][k] + map[k][j];
                    if (map[i][j] > test) {
                        map[i][j] = test;
                        map[j][i] = test;
                    }
                }
            }
        }

        int result = 0;
        int min = INF;
        for (int i = 1; i <= num; i++) {
            int test = Arrays.stream(map[i]).sum();
            if (test < min) {
                min = test;
                result = i;
            }
        }
        System.out.println(result);

    }
}
