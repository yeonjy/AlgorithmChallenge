import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] isVisited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        isVisited = new boolean[n][m];

        // 입력
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int sum) {
        // 끝까지 탐색했으면 최댓값 갱신
        if (depth == n * m) {
            answer = Math.max(sum, answer);
            return;
        }

        int x = depth / m;
        int y = depth % m;

        // 이미 방문했으면 다음 칸 탐색
        if (isVisited[x][y]) {
            dfs(depth + 1, sum);
            return;
        }
        // 현재 칸에서 끊고 다음 칸 탐색
        int num;
        isVisited[x][y] = true;
        num = arr[x][y];
        dfs(depth + 1, sum + num);

        // 현재 칸에서 잇고, 오른쪽 칸 탐색
        int i;
        int temp = num;
        // 오른쪽으로 갈 수 있는 최대로 가면서 각 칸마다 탐색 돌리기
        for (i = x + 1; i < n; i++) {
            if (isVisited[i][y]) {
                break;
            }
            isVisited[i][y] = true;
            temp = temp * 10 + arr[i][y];
            dfs(depth + 1, sum + temp);
        }

        // 오른쪽 탐색한 isVisited 되돌리기
        for (int j = x + 1; j < i; j++) {
            isVisited[j][y] = false;
        }

        // 현재 칸에서 잇고, 아래쪽 칸 탐색
        temp = num;
        for (i = y + 1; i < m; i++) {
            if (isVisited[x][i])
                break;
            isVisited[x][i] = true;
            temp = temp * 10 + arr[x][i];
            dfs(depth + i - y + 1, sum + temp);
        }

        for (int j = y + 1; j < i; j++) {
            isVisited[x][j] = false;
        }
        isVisited[x][y] = false;
    }
}