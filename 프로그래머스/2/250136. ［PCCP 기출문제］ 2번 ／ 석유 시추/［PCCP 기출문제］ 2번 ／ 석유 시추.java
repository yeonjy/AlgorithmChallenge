import java.util.ArrayList;
import java.util.List;

public class Solution {
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    
    static int size;
    static int num = 1;
    static int N;
    static int M;
    static boolean[][] isVisited;
    static int[][] map;
    static int[][] land;
    static List<Integer> sizeList = new ArrayList<>();

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        isVisited = new boolean[N][M];
        map = new int[N][M];
        sizeList.add(0);  // 빈 땅 index = 0
        this.land = land;
        int answer = 0;
        
        // land 돌아다니면서 석유 크기 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && !isVisited[i][j]) {
                    size = 0;
                    dfs(i, j);
                    num++;
                    sizeList.add(size);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            answer = Math.max(check(i), answer);
        }

        return answer;
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;
        map[x][y] = num;
        size++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny) && !isVisited[nx][ny] && land[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

        static int check(int x) {
        boolean[] isChecked = new boolean[num];
        int oil = 0;
        int now = 0;
        for (int y = 0; y < N; y++) {
            // 현재 검사하려는 곳이 석유이고 이전까지 땅이었으면 계산
            if (land[y][x] == 1 && !isChecked[map[y][x]]) {
                oil += sizeList.get(map[y][x]);
                now = map[y][x];
                isChecked[map[y][x]] = true;
            }
        }
        return oil;
    }
}