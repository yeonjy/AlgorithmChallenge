import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] brokenNumbers = new boolean[10];
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                brokenNumbers[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int result = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);

            boolean isBreak = false;
            for (int j = 0; j < num.length(); j++) {
                if (brokenNumbers[num.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                int min = Math.abs(N - i) + num.length();
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
