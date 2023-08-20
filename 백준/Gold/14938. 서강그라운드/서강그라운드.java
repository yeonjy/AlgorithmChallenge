import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 98765321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        int way = Integer.parseInt(st.nextToken());
        int[][] map = new int[city + 1][city + 1];
        int[] totalItems = new int[city + 1];

        int[] items = new int[city + 1];
        //각 지역별 아이템 수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= city; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int a = 1; a <= city; a++) {
            for (int b = 1; b <= city; b++) {
                if (a == b) {
                    map[a][b] = 0;
                } else {
                    map[a][b] = INF;
                }
            }
        }

        for (int i = 0; i < way; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            map[a][b] = len;
            map[b][a] = len;
        }

        for (int k = 1; k <= city; k++) {
            for (int a = 1; a <= city; a++) {
                for (int b = 1; b <= city; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }

        for (int a = 1; a <= city; a++) {
            for (int b = 1; b <= city; b++) {
                if (map[a][b] <= range) {
                    totalItems[a] += items[b];
                }
            }
        }

        System.out.println(Arrays.stream(totalItems).max().getAsInt());
    }
}

