import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static int[] nodes;
    static boolean[] isVisited;
    static int V;
    static boolean result;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            nodes = new int[V + 1];
            isVisited = new boolean[V + 1];
            graph = new List[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList();
            }
            // 그래프 입력받기
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            result = true;
            // dfs 돌리기
            for (int i = 1; i <= V; i++) {
                if (!isVisited[i]) {
                    nodes[i] = 0;
                    dfs(i);
                }
            }
            if (result) {
                sb.append("YES").append("\n");
                continue;
            }
            sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        // 1. 연결된 노드들 전부 방문 -> 현재 노드와 다른 숫자를 nodes에 저장
        // 연결된 노드에 저장할 색상
        isVisited[node] = true;
        int nextColor = getColor(nodes[node]);
        for (int i = 0; i < graph[node].size(); i++) {
            int nextNode = graph[node].get(i);
            if (isVisited[nextNode]) {  // 방문했던 노드 -> 저장하려는 색상과 같은지 검사
                if (nodes[nextNode] != nextColor) {
                    result = false;
                }
                continue;
            }
            nodes[nextNode] = nextColor;
            dfs(nextNode);
        }
    }

    static int getColor(int nowColor) {
        if (nowColor == 0) {
            return 1;
        }
        return 0;
    }
}
