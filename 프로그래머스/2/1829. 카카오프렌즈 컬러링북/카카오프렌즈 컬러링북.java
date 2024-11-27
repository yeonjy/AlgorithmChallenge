import java.util.ArrayList;
import java.util.List;

public class Solution {
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    static int size;
    static int nowColor;
    static boolean[][] isVisited;
    static int[][] picture;
    static List<Integer> colors;
    static int m;
    static int n;

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        this.picture = picture;
        isVisited = new boolean[m][n];
        colors = new ArrayList<>();

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean isBlank = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isBlank && picture[i][j] == 0) {
                    isBlank = true;
                }
                if (!isVisited[i][j] && picture[i][j] != 0) {
                    size = 0;
                    nowColor = picture[i][j];
                    dfs(i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny) && !isVisited[nx][ny] && picture[nx][ny] == nowColor) {
                dfs(nx, ny);
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
