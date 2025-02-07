import java.util.*;

class Solution {
    static final int[] dx = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
    static final int[] dy = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    
    static char[][] map;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            String[] place = places[i];
            map = new char[5][5];
            for (int j = 0; j < place.length; j++) {
                map[j] = place[j].toCharArray();
            }
            answer[i] = check();
        }
        
        return answer;
    }
    
    static int check() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    if (!isPossible(i, j)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    static boolean isPossible(int x, int y) {
        boolean[] isP = new boolean[4];
        
        // 상하좌우 검사
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny)) {
                int res = isPerson(nx, ny);
                if (res == -1) {
                    return false;
                }
                if (res == 0) {
                    isP[i] = true;
                }
                if (res == 1) {  // 빈테이블일 때 다음 칸 검사
                    nx += dx[i];
                    ny += dy[i];
                    if (isValid(nx, ny)) {
                        res = isPerson(nx, ny);
                        if (res == -1) {
                            return false;
                        }
                    }
                }

            }
            
        }
        
        // 대각선 검사
        if (!(isP[0] && isP[2])) {
            int nx = x - 1;
            int ny = y - 1;
            if (isValid(nx, ny)) {
                int res = isPerson(nx, ny);
                if (res == -1) {
                    return false;
                }
            }
        }
            
        if (!(isP[0] && isP[3])) {
            int nx = x - 1;
            int ny = y + 1;
            if (isValid(nx, ny)) {
                int res = isPerson(nx, ny);
                if (res == -1) {
                    return false;
                }
            }
        }
            
        if (!(isP[1] && isP[2])) {
            int nx = x + 1;
            int ny = y - 1;
            if (isValid(nx ,ny)) {
                int res = isPerson(nx, ny);
                if (res == -1) {
                    return false;
                }
            }
        }
            
        if (!(isP[1] && isP[3])) {
            int nx = x + 1;
            int ny = y + 1;
            if (isValid(nx, ny)) {
                int res = isPerson(nx, ny);
                if (res == -1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }
    
    static int isPerson(int x, int y) {
        char next = map[x][y];
        if (next == 'P') {
            return -1;
        }
        if (next == 'X') {  // 파티션이면 다음 방향 검사
            return 0;
        }
        return 1;
    }
}