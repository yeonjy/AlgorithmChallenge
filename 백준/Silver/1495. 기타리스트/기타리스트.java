import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] volumes = new boolean[N + 1][M + 1];
        volumes[0][S] = true;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= M; j++) {
                if (volumes[i - 1][j]) {
                    if (j + now <= M) {
                        volumes[i][j + now] = true;
                    }
                    if (j - now >= 0) {
                        volumes[i][j - now] = true;
                    }
                }
            }

        }

        int result = -1;
        for (int i = M; i >= 0; i--) {
            if (volumes[N][i]) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
