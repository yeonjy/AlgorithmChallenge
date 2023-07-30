import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final char GREEN = 'G';
    static final char RED = 'R';

    static char[][] map;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        int cntNormal = 0;
        int cntColorBlind = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        map = new char[num + 2][num + 2];
        isVisited = new boolean[num + 2][num + 2];
        for (int i = 1; i < num + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < num + 1; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < num + 1; j++) {
                if (!isVisited[i][j]) {
                    cntNormal++;
                    dfs(i, j);
                }
            }
        }

        isVisited  = new boolean[num + 2][num + 2];
        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < num + 1; j++) {
                if (!isVisited[i][j]) {
                    cntColorBlind++;
                    dfsColorBlind(i, j);
                }
            }
        }

        System.out.println(cntNormal + " " + cntColorBlind);
    }

    static void dfs(int x,  int y) {
        char color = map[x][y];
        isVisited[x][y] = true;
        if (!isVisited[x + 1][y] && map[x + 1][y] == color) {
            dfs(x + 1, y);
        }

        if (!isVisited[x - 1][y] && map[x - 1][y] == color) {
            dfs(x - 1, y);
        }

        if (!isVisited[x][y + 1] && map[x][y + 1] == color) {
            dfs(x, y + 1);
        }

        if (!isVisited[x][y - 1] && map[x][y - 1] == color) {
            dfs(x, y - 1);
        }
    }

    static void dfsColorBlind(int x,  int y) {
        List<Character> colors = new ArrayList<>();
        if (map[x][y] == RED || map[x][y] == GREEN) {
            colors.add(RED);
            colors.add(GREEN);
        }
        else {
            colors.add(map[x][y]);
        }
        isVisited[x][y] = true;
        if (!isVisited[x + 1][y] && colors.contains(map[x + 1][y])) {
            dfsColorBlind(x + 1, y);
        }

        if (!isVisited[x - 1][y] && colors.contains(map[x - 1][y])) {
            dfsColorBlind(x - 1, y);
        }

        if (!isVisited[x][y + 1] && colors.contains(map[x][y + 1])) {
            dfsColorBlind(x, y + 1);
        }

        if (!isVisited[x][y - 1] &&  colors.contains(map[x][y - 1])) {
            dfsColorBlind(x, y - 1);
        }
    }
}
