import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int p1;
    static int p2;
    static ArrayList<Integer>[] family;
    static boolean[] isVisited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        family = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            family[i + 1] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            family[x].add(y);
            family[y].add(x);
        }
        bfs(0, p1);
        if (result > n) {
            result = -1;
        }
        System.out.println(result);
    }

    static void bfs(int cnt, int next) {
        isVisited[next] = true;
        if (next == p2 && (cnt < result)) {
            result = cnt;
        }
        if (cnt > n) {
            return;
        }

        for (int i : family[next]) {
            if (!isVisited[i]) {
                bfs(cnt + 1, i);
            }
        }
    }
}
