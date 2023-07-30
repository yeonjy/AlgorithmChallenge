import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static boolean[][] map;
    static boolean[][] isVisited;
    static int[][] garbages;
    static int cnt;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < test; i++) {
            input();
        }



        System.out.println(sb);
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        cnt = num;
        map = new boolean[width + 2][height + 2];
        isVisited = new boolean[width + 2][height + 2];
        garbages = new int[num][2];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 1;
            int y = Integer.parseInt(st.nextToken()) + 1;

            map[x][y] = true;
            garbages[i][0] = x;
            garbages[i][1] = y;
        }

        for (int[] garbage : garbages) {
            if (!isVisited[garbage[0]][garbage[1]]) {
                bfs(garbage[0], garbage[1]);
            }
        }
        sb.append(cnt);
        sb.append("\n");
    }

    static void bfs(int x, int y) {
        isVisited[x][y] = true;
        if (!isVisited[x + 1][y] && map[x + 1][y]) {
            cnt--;
            bfs(x + 1, y);
        }
        if (!isVisited[x - 1][y] && map[x - 1][y]) {
            cnt--;
            bfs(x - 1, y);
        }
        if (!isVisited[x][y + 1] && map[x][y + 1]) {
            cnt--;
            bfs(x, y + 1);
        }
        if (!isVisited[x][y - 1] && map[x][y - 1]) {
            cnt--;
            bfs(x, y - 1);
        }

    }
}
