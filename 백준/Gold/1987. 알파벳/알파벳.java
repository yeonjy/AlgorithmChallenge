import java.util.Scanner;

public class Main {
    static int mapX;
    static int mapY;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        mapX = scan.nextInt();
        mapY = scan.nextInt();
        map = new int[mapX][mapY];
        scan.nextLine();

        for (int i = 0; i < mapX; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < mapY; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }
        isVisited = new boolean[mapX * mapY];
        backtracking(0, 0, 1);

        System.out.println(max);
    }

    static void backtracking(int x, int y, int len) {
        isVisited[map[x][y]] = true;
        max = Math.max(max, len);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < mapX && nextY < mapY) {
                if (!isVisited[map[nextX][nextY]]) {
                    backtracking(nextX, nextY, len + 1);
                    isVisited[map[nextX][nextY]] = false;
                }
            }
        }
    }
}
