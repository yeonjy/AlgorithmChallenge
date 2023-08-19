import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int student = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int[][] map = new int[student + 1][student + 1];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = -1;
        }

        for (int k = 1; k <= student; k++) {
            for (int a = 1; a <= student; a++) {
                for (int b = 1; b <= student; b++) {
                    int test = map[a][k] + map[k][b];
                    if (test != 0) {
                        if (test == 2) {
                            map[a][b] = 1;
                        }
                        if (test == -2) {
                            map[a][b] = -1;
                        }
                    }
                }
            }
        }

        int res = student;
        for (int a = 1; a <= student; a++) {
            for (int b = 1; b <= student; b++) {
                if (map[a][b] == 0 && a != b) {
                    res--;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
