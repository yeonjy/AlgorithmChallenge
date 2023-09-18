import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];
    static boolean[][] isVisitedSquare = new boolean[9][10];
    static boolean[][] isVisitedRow = new boolean[9][10];
    static boolean[][] isVisitedCol = new boolean[9][10];
    static List<int[]> blanks = new ArrayList<>();
    static boolean done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 0) {
                    blanks.add(new int[]{i, j});
                } else {
                    isVisitedSquare[i / 3 + j / 3 * 3][num] = true;
                    isVisitedRow[i][num] = true;
                    isVisitedCol[j][num] = true;
                }
            }
        }

        backtracking(blanks.size() - 1);
    }

    static void backtracking(int depth) {
        if (depth == -1) {
            done = true;
            printMap();
            return;
        }

        int[] blank = blanks.get(depth);
        int x = blank[0];
        int y = blank[1];

        for (int i = 1; i <= 9; i++) {
            map[x][y] = i;
            if (!done && isValid(x, y, i)) {
                backtracking(depth - 1);
                isVisitedSquare[x / 3 + y / 3 * 3][i] = false;
                isVisitedRow[x][i] = false;
                isVisitedCol[y][i] = false;
            }
            map[x][y] = 0;
        }
    }

    static boolean isValid(int x, int y, int num) {
        if (isValidSquare(x, y, num) && isValidRow(x, num) && isValidCol(y, num)) {
            isVisitedSquare[x / 3 + y / 3 * 3][num] = true;
            isVisitedRow[x][num] = true;
            isVisitedCol[y][num] = true;
            return true;
        }
        return false;
    }


    static boolean isValidSquare(int x, int y, int num) {
        return !isVisitedSquare[x / 3 + y / 3 * 3][num];
    }

    private static boolean isValidRow(int x, int num) {
        return !isVisitedRow[x][num];
    }

    private static boolean isValidCol(int y, int num) {
        return !isVisitedCol[y][num];
    }


    private static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
