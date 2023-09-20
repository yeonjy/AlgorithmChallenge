import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[][] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1];
        arr = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                dfs(i);
                result++;
            }
        }
        
        System.out.println(result);
    }

    static void dfs(int num) {
        if (isVisited[num]) {
            return;
        }

        isVisited[num] = true;
        for (int i = 1; i <= N; i++) {
            if (arr[num][i] && !isVisited[i]) {
                dfs(i);
            }
        }
    }
}
