import java.util.*;

class Solution {
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    
    static int xlen;
    static int ylen;
    static char[][] map;
    static boolean[][] isVisited;
    
    public int solution(String[] maps) {
        xlen = maps.length;
        ylen = maps[0].length();
        map = new char[xlen][ylen];
        
        int[] start = new int[2];
        int[] le = new int[2];
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (map[i][j] == 'L') {
                    le[0] = i;
                    le[1] = j;
                }
            }
        }
        int ans1 = bfs(start[0], start[1], 'L');
        int ans2 = bfs(le[0], le[1], 'E');
        if (ans1 == -1 || ans2 == -1) {
            return -1;
        }
        return ans1 + ans2;
    }
    
    static int bfs(int x, int y, char dest) {
        isVisited = new boolean[xlen][ylen];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            if (map[now[0]][now[1]] == dest) {
                return now[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (isValid(nx, ny) && !isVisited[nx][ny] && map[nx][ny] != 'X') {
                    q.add(new int[]{nx, ny, now[2] + 1});
                    isVisited[nx][ny] = true;
                }
            }
        }
        return -1;    
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < xlen && y < ylen;
    }
}