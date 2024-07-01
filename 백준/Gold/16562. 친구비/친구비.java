import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] isVisited;
    static List[] relations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int total = 0;
        List<int[]> costs = new ArrayList<>();
        isVisited = new boolean[N + 1];
        relations = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            relations[i] = new ArrayList<>();
        }

        // 친구비 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            costs.add(i - 1, new int[]{i, Integer.parseInt(st.nextToken())});
        }

        // 친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[a].add(b);
            relations[b].add(a);
        }

        // 친구비 기준 정렬
        costs.sort((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < N; i++) {
            int friend = costs.get(i)[0];
            int cost = costs.get(i)[1];
            if (isVisited[friend]) {
                continue;
            }
            total += cost;
            if (total > k) {
                total = 0;
                break;
            }
            dfs(friend);
        }

        if (total == 0) {
            System.out.println("Oh no");
        } else {
            System.out.println(total);
        }
    }

    static private void dfs(int friend) {
        if (isVisited[friend]) {
            return;
        }
        isVisited[friend] = true;

        List<Integer> now = relations[friend];
        for (int i = 0; i < now.size(); i++) {
            dfs(now.get(i));
        }
    }
}
