import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_LEN = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int G = Integer.parseInt(br.readLine());

        long[] arr = new long[MAX_LEN + 1];
        for (int i = 1; i <= MAX_LEN; i++) {
            arr[i] = (long) i * i;
        }

        int p1 = 1;
        int p2 = 2;
        while (p1 < p2) {
            long minus = arr[p2] - arr[p1];
            if (minus < G) {
                p2++;
            } else if (minus == G) {
                sb.append(p2).append('\n');
                p1++;
                p2++;
            } else {
                p1++;
            }
        }
        if (sb.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
