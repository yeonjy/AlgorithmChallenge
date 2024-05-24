import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] limit;
    static boolean[][] check;
    static Set<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        limit = new int[3];
        check = new boolean[201][201];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        answer = new TreeSet<>();
        dfs(0, 0, limit[2]);

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int a, int b, int c) {
        if (check[a][b]) {
            return;
        }

        if (a == 0) {
            answer.add(c);
        }

        check[a][b] = true;

        if (a + b > limit[1]) {
            dfs((a + b) - limit[1], limit[1], c);
        } else {
            dfs(0, a + b, c);
        }

        if (a + b > limit[0]) {
            dfs(limit[0], a + b - limit[0], c);
        } else {
            dfs(a + b, 0, c);
        }

        if(a+c > limit[0]) {
            dfs(limit[0], b, a+c-limit[0]);
        }else {
            dfs(a+c, b, 0);
        }

        if(b+c > limit[1]) 	{
            dfs(a, limit[1], b+c-limit[1]);
        }else {
            dfs(a, b+c, 0);
        }

        dfs(a, 0, b+c);

        dfs(0, b, a+c);
    }
}
