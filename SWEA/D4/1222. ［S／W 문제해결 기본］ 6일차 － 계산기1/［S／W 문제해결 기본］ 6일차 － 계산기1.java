import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int res = 0;
            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();
            for (int i = 0; i < line.length(); i += 2) {
                res += line.charAt(i) - '0';
            }

            // 답 출력
            sb.append("#" + tc + " " + res + "\n");
        }
        System.out.println(sb);
    }
}
