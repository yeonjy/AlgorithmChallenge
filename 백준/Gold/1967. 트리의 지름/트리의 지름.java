import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int ZERO = 0;
    static class Node {
        int child;
        int len;

        public Node(int child, int len) {
            this.child = child;
            this.len = len;
        }
    }

    static List<Node>[] tree;
    static boolean[] isVisited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //트리 초기화
        tree = new List[size + 1];
        for (int i = 1; i <= size; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < size - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, len));
            tree[child].add(new Node(parent, len));
        }

        //알고리즘 돌리기
        for (int i = 1; i <= size; i++) {
            isVisited = new boolean[size + 1];
            isVisited[i] = true;
            dfs(i, ZERO);
        }

        System.out.println(result);
    }

    static void dfs(int parent, int weight) {
        for (Node node : tree[parent]) {
            if (!isVisited[node.child]) {
                isVisited[node.child] = true;
                dfs(node.child, weight + node.len);
            }
        }
        result = Math.max(result, weight);
    }
}
