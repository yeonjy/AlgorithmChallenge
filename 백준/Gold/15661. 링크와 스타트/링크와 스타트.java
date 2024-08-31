import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] team;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        team = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(min);

    }

    static void dfs(int idx) {
        if (idx == N) {
            checkMinimum();
            return;
        }
        team[idx] = true;
        dfs(idx + 1);
        team[idx] = false;
        dfs(idx + 1);
    }

    static void checkMinimum() {
        int team1 = 0;
        int team2 = 0;
        for (int i = 0; i < N; i++) {
            if (team[i]) {
                for (int j = i + 1; j < N; j++) {
                    if (team[j]) {
                        team1 += map[i][j] + map[j][i];
                    }
                }
            } else {
                for (int j = i + 1; j < N; j++) {
                    if (!team[j]) {
                        team2 += map[i][j] + map[j][i];
                    }
                }
            }
        }
        min = Math.min(min, Math.abs(team1 - team2));
    }
}
