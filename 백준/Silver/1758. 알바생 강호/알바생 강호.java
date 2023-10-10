import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] tips = new Long[N];

        for (int i = 0; i < N; i++) {
            tips[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(tips, Collections.reverseOrder());

        long result = 0;
        for (int i = 0; i < N; i++) {
            long tip = tips[i] - i;
            if (tip > 0) {
                result += tip;
            }
        }
        System.out.println(result);
    }
}
