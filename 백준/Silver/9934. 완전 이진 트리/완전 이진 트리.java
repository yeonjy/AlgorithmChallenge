import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int num;
    static int[] nodes;
    static boolean[] isVisited;
    static List<Integer>[] levels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N];
        levels = new List[N];
        for (int i = 0; i < N; i++) {
            levels[i] = new ArrayList();
        }

        //숫자 입력
        num = (int) Math.pow(2, N) - 1;
        nodes = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }


        tree(nodes, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int node : levels[i]) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void tree(int[] arr, int level) {

        if (level == N) {
            return;
        }
        levels[level].add(arr[arr.length / 2]);

        tree(Arrays.copyOfRange(arr, 0, arr.length / 2), level + 1);
        tree(Arrays.copyOfRange(arr, arr.length / 2 + 1, arr.length), level + 1);
    }

}
