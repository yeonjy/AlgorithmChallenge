import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int ZERO = 0;

    static int[] arr;
    static boolean[] isVisited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n + 1];
        arr = new int[m];

        backtracking(ZERO);
    }

    static void backtracking(int size) {
        if (size == m) {
            print();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                arr[size] = i;
                isVisited[i] = true;
                backtracking(size + 1);
                isVisited[i] = false;
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(a -> sb.append(a).append(" "));
        System.out.println(sb);
    }
}
