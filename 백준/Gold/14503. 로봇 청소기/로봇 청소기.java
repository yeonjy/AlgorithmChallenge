import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isCleaned;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isCleaned = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int direc = Integer.parseInt(st.nextToken());

        //지도 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int blank = Integer.parseInt(st.nextToken());
                map[i][j] = blank;
                if (blank == 1) {
                    isCleaned[i][j] = true;
                }
            }
        }
        clean(r, c, direc);
        System.out.println(cnt);
    }

    private static void clean(int x, int y, int direc) {
        //시작 장소 청소가 안되어있으면 청소
        if (!isCleaned[x][y]) {
            cnt++;
            isCleaned[x][y] = true;
        }
        //현재 칸 주변 4칸이 전부 청소되어있는지 보기 (2)
        if (isNotCleaned(x, y)) {
            //동서남북 보면서 청소 안되어있는 곳 -> 재귀 -> 청소
            if (direc == NORTH) {  //서 -> 남 -> 동 -> 북
                if (isValid(x, y - 1) && !isCleaned[x][y - 1]) {  //서
                    clean(x, y - 1, WEST);
                } else if (isValid(x + 1, y) && !isCleaned[x + 1][y]) {  //남
                    clean(x + 1, y, SOUTH);
                } else if (isValid(x, y + 1) && !isCleaned[x][y + 1]) {  //동
                    clean(x, y + 1, EAST);
                } else {
                    clean(x - 1, y, NORTH);
                }
            } else if (direc == WEST) {  //남 -> 동 -> 북 -> 서
                if (isValid(x + 1, y) && !isCleaned[x + 1][y]) {  //남
                    clean(x + 1, y, SOUTH);
                } else if (isValid(x, y + 1) && !isCleaned[x][y + 1]) {  //동
                    clean(x, y + 1, EAST);
                } else if (isValid(x - 1, y) && !isCleaned[x - 1][y]) {  //북
                    clean(x - 1, y, NORTH);
                } else {
                    clean(x, y - 1, WEST);
                }
            } else if (direc == SOUTH) {  //동 -> 북 -> 서 -> 남
                if (isValid(x, y + 1) && !isCleaned[x][y + 1]) {  //동
                    clean(x, y + 1, EAST);
                } else if (isValid(x - 1, y) && !isCleaned[x - 1][y]) {  //북
                    clean(x - 1, y, NORTH);
                } else if (isValid(x, y - 1) && !isCleaned[x][y - 1]) {  //서
                    clean(x, y - 1, WEST);
                } else {  //남
                    clean(x + 1, y, SOUTH);
                }
            } else {  //동일때   북 -> 서 -> 남 -> 동
                if (isValid(x - 1, y) && !isCleaned[x - 1][y]) {  //북
                clean(x - 1, y, NORTH);
                } else if (isValid(x, y - 1) && !isCleaned[x][y - 1]) {  //서
                    clean(x, y - 1, WEST);
                } else if (isValid(x + 1, y) && !isCleaned[x + 1][y]) {  //남
                    clean(x + 1, y, SOUTH);
                } else {  //동
                    clean(x, y + 1, EAST);
                }
            }
        //동서남북 전부 청소됨
        } else if (direc == NORTH && isValid(x + 1, y) && map[x + 1][y] != 1) {  //북쪽 바라보고 뒤가 벽이 아닐 때
            clean(x + 1, y, direc);
        } else if (direc == WEST && isValid(x, y + 1) && map[x][y + 1] != 1) {
            clean(x, y + 1, direc);
        } else if (direc == SOUTH && isValid(x - 1, y) && map[x - 1][y] != 1) {
            clean(x - 1, y, direc);
        } else if (direc == EAST && isValid(x, y - 1) && map[x][y - 1] != 1) {
            clean(x, y - 1, direc);
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    //동서남북 보면서 청소 안된 곳 있으면 true 반환
    static boolean isNotCleaned(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            //갈 수 있는 곳 & 청소 안된 곳
            if (isValid(nextX, nextY) && !isCleaned[nextX][nextY]) {
                return true;
            }
        }
        return false;
    }
}