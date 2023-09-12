
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> choice = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] isvisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                }
                if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        isvisited = new boolean[chicken.size()];
        backtracking(0, 0);
        System.out.println(result);
    }

    static void backtracking(int depth, int start) {
        if (depth == m) {
            int sum = 0;
            for (int[] h : house) {
                int min = Integer.MAX_VALUE;
                for (int[] c : choice) {
                    int distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(distance, min);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            if (!isvisited[i]) {
                isvisited[i] = true;
                choice.add(chicken.get(i));
                backtracking(depth + 1, i + 1);
                choice.remove(choice.size() - 1);
                isvisited[i] = false;
            }
        }
    }
}
