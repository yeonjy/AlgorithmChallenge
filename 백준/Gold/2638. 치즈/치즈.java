import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    static int CHEESE = 1;
    static int NOT_CHEESE = 0;

    static List<int[]> deleteCheese;

    static int[][] map;
    static boolean[][] isOutside;
    static int N;
    static int M;
    static int cheeseCnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        deleteCheese = new ArrayList<>();
        map = new int[N][M];
        isOutside = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if (tmp == CHEESE) {
                     cheeseCnt++;
                }
            }
        }

        findOutside(0, 0);

        int hour = 0;
        while (cheeseCnt > 0) {
            hour++;
            deleteCheese = new ArrayList<>();
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    if (map[i][j] == CHEESE) {
                        dfs(i, j);
                    }
                }
            }

            for (int[] delete : deleteCheese) {
                map[delete[0]][delete[1]] = 0;
                cheeseCnt--;
                findOutside(delete[0], delete[1]);
            }

        }
        System.out.println(hour);
    }

    static void findOutside(int x, int y) {
        isOutside[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValid(nextX, nextY) && !isOutside[nextX][nextY] && map[nextX][nextY] == NOT_CHEESE) {
                findOutside(nextX, nextY);
            }
        }
    }


    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static void dfs(int x, int y) {
        if (map[x][y] == CHEESE) {
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (isValid(nextX, nextY) && isOutside[nextX][nextY]) {
                    cnt++;
                }
            }
            if (cnt >= 2) {
                deleteCheese.add(new int[]{x, y});
            }
        }
    }
}
