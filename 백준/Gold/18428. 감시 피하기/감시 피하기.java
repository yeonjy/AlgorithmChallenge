import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final String YES = "YES";
    static final String NO = "NO";
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};


    static boolean result;
    static int N;
    static String[][] map;
    static boolean[][] isVisited;
    static ArrayList<int[]> teacherLocs = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        isVisited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("T")) {
                    teacherLocs.add(new int[]{i, j});
                    isVisited[i][j] = true;
                } else if (map[i][j].equals("S")) {
                    isVisited[i][j] = true;
                }

            }
        }

        backtracking(0, 0, 0);
        
        if (result) {
            System.out.println(YES);
        } else {
            System.out.println(NO);
        }

    }

    static void backtracking(int x, int y, int depth) {
        if (result) {
            return;
        }

        if (depth == 3) {
            if (checkAvoid()) {
                result = true;
            }
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    map[i][j] = "O";
                    isVisited[i][j] = true;
                    backtracking(i, j, depth + 1);
                    isVisited[i][j] = false;
                    map[i][j] = "X";
                }
            }
        }
    }

    static boolean checkAvoid() {
        for (int[] teacher : teacherLocs) {
            int x = teacher[0];
            int y = teacher[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                while (nextX != N && nextX != -1 && nextY != N && nextY != -1) {

                    if (map[nextX][nextY].equals("S")) {
                        return false;
                    }
                    if (map[nextX][nextY].equals("O")) {
                        break;
                    }
                    nextX = nextX + dx[i];
                    nextY = nextY + dy[i];
                }
            }
        }
        return true;
    }
}
