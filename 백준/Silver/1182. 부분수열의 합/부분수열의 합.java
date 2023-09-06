import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int ZERO = 0;

    static int N;
    static int S;
    static int cnt;
    static int[] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(ZERO, ZERO);
        if (S == ZERO) {
            cnt -= 1;
        }
        System.out.println(cnt);
    }

    static void backtracking(int sum, int index) {
        if (sum == S) {
            cnt++;
        }
        for (int i = index; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                backtracking(sum + arr[i], i);
                isVisited[i] = false;
            }
        }
    }
}
