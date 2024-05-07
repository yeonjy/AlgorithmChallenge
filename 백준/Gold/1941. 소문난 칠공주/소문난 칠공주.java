import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map;
    static int answer = 0;
    static boolean[] isVisited;
    static int[] selected = new int[7];
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        for(int r = 0; r < 5; r++) {
            map[r] = br.readLine().toCharArray();
        }
        backtracking(0, 0, 0);
        
        System.out.println(answer);
    }

    static void backtracking(int depth, int numY, int start) {
        if (numY >= 4) {
            return;
        }
        if (depth == 7) {
            isVisited = new boolean[7];
            bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[depth] = i;
            if (map[i / 5][i % 5] == 'Y') {
                backtracking(depth + 1, numY + 1, i + 1);
            } else {
                backtracking(depth + 1, numY, i + 1);
            }
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{selected[0] / 5, selected[0] % 5});
        isVisited[0] = true;
        int conn = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int ni = nr * 5 + nc;  // 현재 위치와 연결된 4개가 부여됨

                if (!isValid(nr, nc)) {
                    continue;
                }

                for (int j = 0; j < 7; j++) {
                    if (!isVisited[j] && selected[j] == ni) {  //선택된 것들 중 연결된 것이 있는지 확인
                        q.add(new int[]{nr, nc});
                        isVisited[j] = true;
                        conn++;
                    }
                }
            }
        }
        if (conn == 7) {
            answer++;
        }
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }
}
