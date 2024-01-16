import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Room {
        boolean[] walls;  //서 | 북 | 동 | 남

        public Room(boolean[] walls) {
            this.walls = walls;
        }
    }

    static final int WEST = 1;
    static final int NORTH = 2;
    static final int EAST = 4;
    static final int SOUTH = 8;

    static final int[] dx = {0, -1, 0, 1};  //서 북 동 남
    static final int[] dy = {-1, 0, 1, 0};

    static int N;
    static int M;
    static Room[][] map;
    static boolean[][] isVisited;
    static int[][] roomNums;
    static int roomCnt;
    static int roomSize;
    static int[] roomSizes;
    static int maxSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Room[M][N];
        isVisited = new boolean[M][N];
        roomNums = new int[M][N];
        roomSizes = new int[M * N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = makeWalls(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    roomCnt++;
                    dfs(i, j);
                    roomSizes[roomCnt] = roomSize;
                    roomSize = 0;
                }
            }
        }

        isVisited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    findRemoveWall(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomCnt).append("\n").append(Arrays.stream(roomSizes).max().getAsInt()).append("\n").append(maxSize);
        System.out.println(sb);

    }

    static Room makeWalls(int totalWall) {
        if (totalWall == 0) {
            return new Room(new boolean[]{false, false, false, false});
        } else if (totalWall == WEST) {
            return new Room(new boolean[]{true, false, false, false});
        } else if (totalWall == NORTH) {
            return new Room(new boolean[]{false, true, false, false});
        } else if (totalWall == 3) {
            return new Room(new boolean[]{true, true, false, false});
        } else if (totalWall == EAST) {
            return new Room(new boolean[]{false, false, true, false});
        } else if (totalWall == 5) {
            return new Room(new boolean[]{true, false, true, false});
        } else if (totalWall == 6) {
            return new Room(new boolean[]{false, true, true, false});
        } else if (totalWall == 7) {
            return new Room(new boolean[]{true, true, true, false});
        } else if (totalWall == SOUTH) {
            return new Room(new boolean[]{false, false, false, true});
        } else if (totalWall == 9) {
            return new Room(new boolean[]{true, false, false, true});
        } else if (totalWall == 10) {
            return new Room(new boolean[]{false, true, false, true});
        } else if (totalWall == 11) {
            return new Room(new boolean[]{true, true, false, true});
        } else if (totalWall == 12) {
            return new Room(new boolean[]{false, false, true, true});
        } else if (totalWall == 13) {
            return new Room(new boolean[]{true, false, true, true});
        } else if (totalWall == 14) {
            return new Room(new boolean[]{false, true, true, true});
        } else {
            return new Room(new boolean[]{true, true, true, true});
        }
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;
        roomNums[x][y] = roomCnt;
        roomSize++;

        //서쪽에 있는 칸
        int nextX = x + dx[0];
        int nextY = y + dy[0];
        if (isValid(nextX, nextY) && !isVisited[nextX][nextY] && !map[nextX][nextY].walls[2]) {
            dfs(nextX, nextY);
        }

        //북쪽에 있는 칸
        nextX = x + dx[1];
        nextY = y + dy[1];
        if (isValid(nextX, nextY) && !isVisited[nextX][nextY] && !map[nextX][nextY].walls[3]) {
            dfs(nextX, nextY);
        }

        //동쪽에 있는 칸
        nextX = x + dx[2];
        nextY = y + dy[2];
        if (isValid(nextX, nextY) && !isVisited[nextX][nextY] && !map[nextX][nextY].walls[0]) {
            dfs(nextX, nextY);
        }

        //남쪽에 있는 칸
        nextX = x + dx[3];
        nextY = y + dy[3];
        if (isValid(nextX, nextY) && !isVisited[nextX][nextY] && !map[nextX][nextY].walls[1]) {
            dfs(nextX, nextY);
        }

    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    static void findRemoveWall(int x, int y) {
        isVisited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValid(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (roomNums[x][y] != roomNums[nextX][nextY]) {
                    maxSize = Math.max(maxSize, roomSizes[roomNums[x][y]] + roomSizes[roomNums[nextX][nextY]]);
                }
            }
        }
    }
}
