import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    static class Point {
        int x;
        int y;
        int depth;

        Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    static int N;
    static int M;
    static char[][] map;
    static boolean[][] isVisited;

    public int solution(String[] board) {
        int x = 0;
        int y = 0;

        map = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < board[0].length(); j++) {
                if (map[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        N = map.length;
        M = map[0].length;
        isVisited = new boolean[N][M];
        return bfs(x, y);
    }

    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (map[p.x][p.y] == 'G') {
                return p.depth;
            }

            if (isVisited[p.x][p.y]) {
                continue;
            }
            isVisited[p.x][p.y] = true;

            List<int[]> list = new ArrayList<>();
            list.add(down(p.x, p.y));
            list.add(up(p.x, p.y));
            list.add(right(p.x, p.y));
            list.add(left(p.x, p.y));

            for (int[] now : list) {
                if (p.x != now[0] || p.y != now[1]) {
                    queue.add(new Point(now[0], now[1], p.depth + 1));
                }
            }
        }
        return -1;
    }

    static int[] down(int x, int y) {
        while (x != N - 1) {
            x++;
            if (map[x][y] == 'D') {
                return new int[]{x - 1, y};
            }
        }
        return new int[]{x, y};
    }

    static int[] up(int x, int y) {
        while (x != 0) {
            x--;
            if (map[x][y] == 'D') {
                return new int[]{x + 1, y};
            }
        }
        return new int[]{x, y};
    }

    static int[] right(int x, int y) {
        while (y != M - 1) {
            y++;
            if (map[x][y] == 'D') {
                return new int[]{x, y - 1};
            }
        }
        return new int[]{x, y};
    }

    static int[] left(int x, int y) {
        while (y != 0) {
            y--;
            if (map[x][y] == 'D') {
                return new int[]{x, y + 1};
            }
        }
        return new int[]{x, y};
    }
}
