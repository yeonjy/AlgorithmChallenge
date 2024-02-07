
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] isVisited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isVisited = new boolean[N + 1];

        backtracking(0);
        System.out.println(sb);
    }

    static void backtracking(int size) {
        if (size == M) {
            print();
            return;
        }
        int i;
        if (size == 0) {
            i = 1;
        } else {
            i = arr[size - 1];
        }
        for (; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[size] = i;
                backtracking(size + 1);
                isVisited[i] = false;
            }
        }
    }

    static void print() {
        Arrays.stream(arr).forEach(i -> sb.append(i).append(" "));
        sb.append("\n");
    }
}
