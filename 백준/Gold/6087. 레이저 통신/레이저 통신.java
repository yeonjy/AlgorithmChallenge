import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{1, 0, -1, 0};
    static final int[] dy = new int[]{0, 1, 0, -1};
    static final int[][] directions = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};

    static int H;
    static int W;
    static char[][] map;
    static int[][][] depthMap;

    static class Node {
        int x;
        int y;
        int direction;
        int mirror;

        Node(int x, int y, int direction, int mirror) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.mirror = mirror;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        depthMap = new int[H][W][4];

        int[] start = new int[2];
        int[] finish = new int[2];
        boolean tmp = false;
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < 4; k++) {
                    depthMap[i][j][k] = Integer.MAX_VALUE;
                }
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    if (!tmp) {
                        start = new int[]{i, j};
                        tmp = true;
                    } else {
                        finish = new int[]{i, j};
                    }
                }
            }
        }

        bfs(start);
        System.out.println(Arrays.stream(depthMap[finish[0]][finish[1]]).min().getAsInt());
    }

    static void bfs(int[] start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.mirror - o2.mirror);
        queue.add(new Node(start[0], start[1], 0, 0));
        queue.add(new Node(start[0], start[1], 1, 0));
        queue.add(new Node(start[0], start[1], 2, 0));
        queue.add(new Node(start[0], start[1], 3, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 현재 방향 그대로 진행
            int nextX = now.x + dx[now.direction];
            int nextY = now.y + dy[now.direction];
            if (isValid(nextX, nextY) && depthMap[nextX][nextY][now.direction] > now.mirror) {
                depthMap[nextX][nextY][now.direction] = now.mirror;
                queue.add(new Node(nextX, nextY, now.direction, now.mirror));
            }
            // 방향 전환
            for (int i = 0; i < 2; i++) {
                nextX = now.x + dx[directions[now.direction][i]];
                nextY = now.y + dy[directions[now.direction][i]];
                // 갈 수 있는 곳인지 / 벽일 때 / 거울 수 고려
                if (isValid(nextX, nextY)) {
                    // 거울 -> 방향 전환
                    if (depthMap[nextX][nextY][directions[now.direction][i]] > now.mirror + 1) {
                        depthMap[nextX][nextY][directions[now.direction][i]] = now.mirror + 1;
                        queue.add(new Node(nextX, nextY, directions[now.direction][i], now.mirror + 1));
                    }
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < H && y < W && map[x][y] != '*';
    }
}
