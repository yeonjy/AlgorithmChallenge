import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static boolean[][] isVisited;
    static int N;
    static int M;
    static int[] dx = { -1, 1, 0, 0 };  //상 하
    static int[] dy = { 0, 0, -1, 1 };  //좌 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N + 2][M + 2];
        field = new int[N + 2][M + 2];
        for (int i = 1; i < N + 1; i++) {
            String[] words = br.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                field[i][j] = Integer.parseInt(words[j - 1]);
            }
        }
        isVisited[1][1] = true;
        bfs(1, 1);
        System.out.println(field[N][M]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if (checkValid(nextX, nextY)) {
                    queue.add(new int[] {nextX, nextY});
                    field[nextX][nextY] = field[nowX][nowY] + 1;
                    isVisited[nextX][nextY] = true;
                }
            }
        }
    }

    static boolean checkValid(int nextX, int nextY) {
        if ((nextX > 1 || nextY > 1) && (nextX <= N + 1 || nextY <= M + 1)
                && (!isVisited[nextX][nextY] && field[nextX][nextY] > 0)) {
                return true;
        }
        return false;
    }

}

