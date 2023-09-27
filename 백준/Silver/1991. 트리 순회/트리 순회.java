import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int left;
        int right;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static Node[] tree;
    static StringBuilder front = new StringBuilder();
    static StringBuilder middle = new StringBuilder();
    static StringBuilder end = new StringBuilder();
    static boolean[] isVisitedInorder;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];
        isVisitedInorder = new boolean[N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 65;
            int left = st.nextToken().charAt(0) - 65;
            int right = st.nextToken().charAt(0) - 65;
            if (left < 0) {
                left = -1;  //노드가 없는 경우 -> -1
            }
            if (right < 0) {
                right = -1;
            }
            tree[parent] = new Node(left, right);  //부모 인덱스에 자식 노드 저장
        }

        preorder(0);
        inorder(0);
        postorder(0);

        System.out.println(front);
        System.out.println(middle);
        System.out.println(end);

    }

    //전위순회
    static void preorder(int parent) {
        front.append((char)(parent + 65));
        if (tree[parent].left != -1) {  //왼쪽 자식 노드가 존재하면 재귀 호출
            preorder(tree[parent].left);
        }
        if (tree[parent].right != -1) {  //오른쪽 자식 노드가 존재하면 재귀 호출
            preorder(tree[parent].right);
        }
    }

    //중위순회
    static void inorder(int parent) {
        if (tree[parent].left != -1) {
            inorder(tree[parent].left);
        }
        middle.append((char)(parent + 65));
        isVisitedInorder[parent] = true;

        if (tree[parent].right != -1) {
            inorder(tree[parent].right);
            if (!isVisitedInorder[tree[parent].right]) {
                middle.append((char)(tree[parent].right + 65));
                isVisitedInorder[tree[parent].right] = true;
            }
        }
    }

    //후위순회
    static void postorder(int parent) {
        if (tree[parent].left != -1) {
            postorder(tree[parent].left);
        }
        if (tree[parent].right != -1) {
            postorder(tree[parent].right);
        }
        end.append((char) (parent + 65));
    }

}
