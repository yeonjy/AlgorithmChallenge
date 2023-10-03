import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int NONE = -2;

    static int cnt;
    static int removed;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new List[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();  //자식 노드 번호가 저장될 것
        }

        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            }
            else {
                tree[parent].add(i);
            }
        }

        removed = Integer.parseInt(br.readLine());

        dfs(root);
        System.out.println(cnt);
    }

    static void dfs(int parent) {
        if (parent == removed) {
            return;
        }

        int childCnt = tree[parent].size();
        if (childCnt == 0) {
            cnt++;
            return;
        }
        if (childCnt == 1 && tree[parent].get(0) == removed) {
            cnt++;
        }
        for (int i = 0; i < childCnt; i++) {
            dfs(tree[parent].get(i));
        }
    }
}
