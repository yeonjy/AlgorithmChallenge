import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int length = Math.min(N, M);
        while (length > 1) {
            for (int i = 0; i <= N - length; i++) {
                for (int j = 0; j <= M - length; j++) {
                    int k = map[i][j];
                    int size = length - 1;
                    if (k == map[i + size][j] && k == map[i][j + size] && k == map[i + size][j + size]) {
                        System.out.println(length * length);
                        return;
                    }
                }
            }
            length--;
        }
        System.out.println(1);
    }
}
