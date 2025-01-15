import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new int[N + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String strNow = st.nextToken();
            String strLeft = st.nextToken();
            String strRight = st.nextToken();
            int now = strNow.toCharArray()[0] - 'A';
            int left = strLeft.toCharArray()[0] - 'A';
            int right = strRight.toCharArray()[0] - 'A';
            if (strLeft.equals(".")) {
                left = -1;
            }
            if (strRight.equals(".")) {
                right = -1;
            }
            tree[now][0] = left;
            tree[now][1] = right;
        }

        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);

        System.out.println(sb);
    }

    static void preorder(int now) {
        sb.append(Character.toChars(now + 'A'));
        if (tree[now][0] != -1) {
            preorder(tree[now][0]);
        }
        if (tree[now][1] != -1) {
            preorder(tree[now][1]);
        }
    }

    static void inorder(int now) {
        if (tree[now][0] != -1) {
            inorder(tree[now][0]);
        }
        sb.append(Character.toChars(now + 'A'));
        if (tree[now][1] != -1) {
            inorder(tree[now][1]);
        }
    }

    static void postorder(int now) {
        if (tree[now][0] != -1) {
            postorder(tree[now][0]);
        }
        if (tree[now][1] != -1) {
            postorder(tree[now][1]);
        }
        sb.append(Character.toChars(now + 'A'));
    }
}
