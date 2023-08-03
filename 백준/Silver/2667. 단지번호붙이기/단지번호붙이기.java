import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int mapSize;
    static int[][] map;
    static boolean[][] isVisited;
    static int townCnt;
    static ArrayList<Integer> houseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(br.readLine());
        map = new int[mapSize + 2][mapSize + 2];
        isVisited = new boolean[mapSize + 2][mapSize + 2];
        houseCnt = new ArrayList<>();

        for (int i = 1; i < mapSize + 1; i++) {
            String[] line = br.readLine().split("");
            for (int j = 1; j < mapSize + 1; j++) {
                map[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        for (int i = 1; i < mapSize + 1; i++) {
            for (int j = 1; j < mapSize + 1; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    houseCnt.add(0);
                    townCnt++;
                    dfs(i, j);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(townCnt + "\n");

        Collections.sort(houseCnt);
        for (int i = 1; i <= townCnt; i++) {
            bw.write(houseCnt.get(i - 1) + "\n");
        }
        bw.flush();
    }

    static void dfs(int x, int y) {
        houseCnt.set(townCnt - 1, houseCnt.get(townCnt - 1) + 1);
        isVisited[x][y] = true;

        if (map[x + 1][y] == 1 && !isVisited[x + 1][y]) {
            dfs(x + 1, y);
        }

        if (map[x - 1][y] == 1 && !isVisited[x - 1][y]) {
            dfs(x - 1, y);
        }

        if (map[x][y + 1] == 1 && !isVisited[x][y + 1]) {
            dfs(x, y + 1);
        }

        if (map[x][y - 1] == 1 && !isVisited[x][y - 1]) {
            dfs(x, y - 1);
        }
    }
}
