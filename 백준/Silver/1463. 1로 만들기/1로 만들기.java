import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        calculate(N, 0);
        System.out.println(result);
    }

    static void calculate(int now, int cnt) {
        if (cnt > result) {
            return;
        }

        if (now == 1) {
            result = Math.min(result, cnt);
            return;
        }

        if (now % 3 == 0) {
            calculate(now / 3, cnt + 1);
        }
        if (now % 2 == 0) {
            calculate(now / 2, cnt + 1);
        }
        calculate(now - 1, cnt + 1);
    }
}
