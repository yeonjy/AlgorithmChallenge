import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] input;
    static int[] tree;
    static boolean[] isVisited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new List[N + 1];
        isVisited = new boolean[N + 1];
        tree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = new ArrayList<>();
        }

        StringTokenizer st;

        //연결된 노드 입력
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            input[a].add(b);
            input[b].add(a);
        }

        isVisited[1] = true;
        makeTree(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(tree[i]).append("\n");
        }
        System.out.println(sb);

    }

    static void makeTree(int parent) {
        isVisited[parent] = true;
        for (int child : input[parent]) {
            if (!isVisited[child]) {
                tree[child] = parent;  //자식 인덱스에 부모 숫자 저장
                makeTree(child);
            }
        }
    }
}
