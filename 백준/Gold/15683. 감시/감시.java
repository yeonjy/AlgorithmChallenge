import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int[] directions = {0, 1, 2, 3};

    static int N;
    static int M;
    static int[][] isVisited;
    static int[][] map;
    static List<int[]> cctvs;
    static int result = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cctvs = new ArrayList<>();

        isVisited = new int[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 6) {
                    isVisited[i][j]++;
                } else if (num != 0) {
                    isVisited[i][j]++;
                    cctvs.add(new int[]{i, j});
                }
            }
        }
        backtracking(cctvs.size() - 1);
        System.out.println(result);
    }

    static void backtracking(int depth) {
        if (depth == -1) {
            int tmp = getBlindSpotNum();
            if (tmp < result) {
                result = tmp;
            }
            return;
        }
        int[] xy = cctvs.get(depth);
        int y = xy[0];
        int x = xy[1];
        int point = map[y][x];

        if (point == 1) {
            setRight(x, y);
            backtracking(depth - 1);
            setFreeRight(x, y);

            setUp(x, y);
            backtracking(depth - 1);
            setFreeUp(x, y);

            setLeft(x, y);
            backtracking(depth - 1);
            setFreeLeft(x, y);

            setDown(x, y);
            backtracking(depth - 1);
            setFreeDown(x, y);
        } else if (point == 2) {
            setRight(x, y);
            setLeft(x, y);
            backtracking(depth - 1);
            setFreeRight(x, y);
            setFreeLeft(x, y);

            setUp(x, y);
            setDown(x, y);
            backtracking(depth - 1);
            setFreeUp(x, y);
            setFreeDown(x, y);
        } else if (point == 3) {
            setRight(x, y);
            setUp(x, y);
            backtracking(depth - 1);
            setFreeRight(x, y);

            setLeft(x, y);
            backtracking(depth - 1);
            setFreeUp(x, y);

            setDown(x, y);
            backtracking(depth - 1);
            setFreeLeft(x, y);

            setRight(x, y);
            backtracking(depth - 1);
            setFreeDown(x, y);
            setFreeRight(x, y);
        } else if (point == 4) {
            setLeft(x, y);
            setUp(x, y);
            setDown(x, y);
            backtracking(depth - 1);  //오
            setFreeUp(x, y);

            setRight(x, y);
            backtracking(depth - 1);  //위
            setFreeLeft(x, y);

            setUp(x, y);
            backtracking(depth - 1);  //왼
            setFreeDown(x, y);

            setLeft(x, y);
            backtracking(depth - 1);  //아래
            setFreeRight(x, y);
            setFreeUp(x, y);
            setFreeLeft(x, y);
        } else if (point == 5) {
            setRight(x, y);
            setUp(x, y);
            setLeft(x, y);
            setDown(x, y);
            backtracking(depth - 1);
            setFreeRight(x, y);
            setFreeUp(x, y);
            setFreeLeft(x, y);
            setFreeDown(x, y);
        }
    }

    static int getBlindSpotNum() {
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isVisited[i][j] == 0) {
                    num++;
                }
            }
        }
        return num;
    }

    static void setRight(int x, int y) {
        for (int i = x + 1; i < M; i++) {
            if (map[y][i] == 6) {
                return;
            }
            isVisited[y][i]++;
        }
    }

    static void setFreeRight(int x, int y) {
        for (int i = x + 1; i < M; i++) {
            if (map[y][i] == 6) {
                return;
            }
            isVisited[y][i]--;
        }
    }

    static void setLeft(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (map[y][i] == 6) {
                return;
            }
            isVisited[y][i]++;
        }
    }

    static void setFreeLeft(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (map[y][i] == 6) {
                return;
            }
            isVisited[y][i]--;
        }
    }

    static void setUp(int x, int y) {
        for (int i = y + 1; i < N; i++) {
            if (map[i][x] == 6) {
                return;
            }
            isVisited[i][x]++;
        }
    }

    static void setFreeUp(int x, int y) {
        for (int i = y + 1; i < N; i++) {
            if (map[i][x] == 6) {
                return;
            }
            isVisited[i][x]--;
        }
    }

    static void setDown(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (map[i][x] == 6) {
                return;
            }
            isVisited[i][x]++;
        }
    }

    static void setFreeDown(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (map[i][x] == 6) {
                return;
            }
            isVisited[i][x]--;
        }
    }
}
