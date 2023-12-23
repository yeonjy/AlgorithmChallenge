import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int M;
    static int N;
    static boolean[][] map;
    static List sizes;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        sizes = new ArrayList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        int n = Integer.parseInt(st.nextToken());
        //직사각형 있는 곳 map -> true로 변경 (직사각형이 있다는 뜻)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j]) {  //해당 구역에 직사각형이 없고 방문하지 않은 경우
                    queue.add(new Point(i, j));
                    bfs();
                    cnt++;
                }
            }
        }

        Collections.sort(sizes);
        StringBuilder sb = new StringBuilder();
        sizes.forEach(s -> sb.append(s).append(" "));

        System.out.println(cnt);
        System.out.println(sb);
    }

    static void bfs() {
        int size = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int nowX = point.x;
            int nowY = point.y;
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX > -1 && nextX < N && nextY > -1 && nextY < M && (!map[nextX][nextY])) {
                    size++;
                    map[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
        if (size == 0) {
            size = 1;
        }
        sizes.add(size);
    }

    private static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
