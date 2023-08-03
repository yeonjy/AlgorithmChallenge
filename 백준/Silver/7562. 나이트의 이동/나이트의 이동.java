import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] map;
    static int size;
    static boolean[][] isVisited;
    static int[] dx = { -2, -2, -1, -1, +1, +1, +2, +2 };
    static int[] dy = { -1, +1, -2, +2, -2, +2, -1, +1 };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            input();
        }
        bw.flush();

    }

    static void input() throws IOException {
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        isVisited = new boolean[size][size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] knight = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        st = new StringTokenizer(br.readLine());
        int[] destination = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        if (knight[0] == destination[0] && knight[1] == destination[1]) {
            bw.write(0 + "\n");
        } else {
            bfs(knight);
            bw.write(map[destination[0]][destination[1]] + "\n");
        }
    }

    static void bfs(int[] knight) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{knight[0], knight[1]});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < size && nextY < size && !isVisited[nextX][nextY]) {
                    queue.add(new int[] {nextX, nextY});
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    isVisited[nextX][nextY] = true;
                }
            }
        }
    }
}
