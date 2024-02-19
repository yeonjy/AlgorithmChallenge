import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isVisited;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    total++;
                }
            }
        }

        List<Integer> leftCheese = new ArrayList<>();
        leftCheese.add(total);
        int time = 0;
        while (total > 0) {
            time++;
            isVisited = new boolean[N][M];
            bfs(0, 0);
            checkCheese();
            leftCheese.add(total);
        }
        
        System.out.println(time + "\n" + leftCheese.get(leftCheese.size() - 2));
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (isValid(nextX, nextY) && !isVisited[nextX][nextY]) {
                    if (map[nextX][nextY] == 1) {
                        map[nextX][nextY] = 2;
                    } else {
                        isVisited[nextX][nextY] = true;
                        q.add(new int[]{nextX, nextY});
                    }
                    isVisited[nextX][nextY] = true;
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static void checkCheese() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (map[i][j] == 2) {
                    total--;
                    map[i][j] = 0;
                }
            }
        }
    }
}
