import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{0, 0, 1, -1};
    static final int[] dy = new int[]{1, -1, 0, 0};
    static int N;
    static int[][] map = new int[31][31];
    static boolean[][] isVisited = new boolean[31][31];
    static double total;
    static double[] percents = new double[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            percents[i] = Integer.parseInt(st.nextToken()) / 100.0;
        }
        isVisited[15][15] = true;
        dfs(15, 15, 0, 1);

        System.out.println(total);
    }

    static void dfs(int x, int y, int depth, double percent) {
        if (depth == N) {
            total += percent;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isVisited[nextX][nextY]) {
                isVisited[nextX][nextY] = true;
                dfs(nextX, nextY, depth + 1, percent * percents[i]);
                isVisited[nextX][nextY] = false;
            }
        }
    }
}
