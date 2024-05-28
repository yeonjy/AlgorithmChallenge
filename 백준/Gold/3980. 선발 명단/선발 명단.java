import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int max;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            max = 0;
            map = new int[11][11];
            isVisited = new boolean[11];
            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, 0);
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int line, int cost) {
        if (line == 11) {
            max = Math.max(max, cost);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (!isVisited[i] && map[line][i] > 0) {
                isVisited[i] = true;
                dfs(line + 1, cost + map[line][i]);
                isVisited[i] = false;
            }
        }
    }
}
