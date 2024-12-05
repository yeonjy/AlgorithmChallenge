import java.util.Arrays;

public class Solution {
    static int answer;
    static int n;

    public int solution(int n) {
        this.n = n;
        boolean[][] map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dfs(0, i, 1, copyArray(map));
        }
        return answer;
    }

    private static boolean[][] copyArray(boolean[][] map) {
        boolean[][] copy = new boolean[map.length][];
        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }

    private static void dfs(int x, int y, int depth, boolean[][] now) {
        if (depth == n) {
            answer++;
            return;
        }

        now[x][y] = true;
        check(x, y, now);

        // 가능한 좌표 구해서 표시하고 재귀
        for (int i = 0; i < n; i++) {
            if (!now[x + 1][i]) {
                dfs(x + 1, i, depth + 1, copyArray(now));
            }
        }
    }

    static void check(int x, int y, boolean[][] now) {
        int ny = y;
        while (ny > 0) {
            now[x][--ny] = true;
        }

        ny = y;
        while (ny < n - 1) {
            now[x][++ny] = true;
        }

        int nx = x;
        while (nx > 0) {
            now[--nx][y] = true;
        }

        nx = x;
        while (nx < n - 1) {
            now[++nx][y] = true;
        }

        nx = x;
        ny = y;
        while (nx != 0 && ny != 0) {
            now[--nx][--ny] = true;
        }

        nx = x;
        ny = y;
        while (nx != n - 1 && ny != 0) {
            now[++nx][--ny] = true;
        }

        nx = x;
        ny = y;
        while (nx != 0 && ny != n - 1) {
            now[--nx][++ny] = true;
        }

        nx = x;
        ny = y;
        while (nx != n - 1 && ny != n - 1) {
            now[++nx][++ny] = true;
        }
    }
}
