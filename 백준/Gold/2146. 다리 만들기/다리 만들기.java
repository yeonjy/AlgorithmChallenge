import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};

    static int N;
    static boolean[][] isVisited;
    static int[][] map;
    static int groundNum;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N][N];
        map = new int[N][N];
        groundNum = 1;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // map 번호 매기기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j] && map[i][j] != 0) {
                    initialBfs(i, j);
                    groundNum++;
                }
            }
        }

        // 번호가 다른 육지 잇기
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j] && map[i][j] != 0 && isBoundary(i, j)) {
                    isVisited = new boolean[N][N];
                    bfs(i, j, map[i][j]);
                }
            }
        }
        System.out.println(result);
    }

    static void initialBfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            map[nowX][nowY] = groundNum;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (isValid(nextX, nextY) && !isVisited[nextX][nextY] && map[nextX][nextY] != 0) {
                    isVisited[nextX][nextY] = true;
                    q.add(new int[] {nextX, nextY});
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static boolean isBoundary(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValid(nextX, nextY) && map[nextX][nextY] == 0) {
                return true;
            }
        }
        return false;
    }

    static void bfs(int x, int y, int ground) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.distance >= result) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if (isValid(nextX, nextY) && !isVisited[nextX][nextY] && map[nextX][nextY] != ground) {
                    isVisited[nextX][nextY] = true;
                    if (map[nextX][nextY] != 0) {
                        result = now.distance;
                        break;
                    }
                    q.add(new Node(nextX, nextY, now.distance + 1));
                }
            }
        }
    }
}
