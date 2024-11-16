import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static List<Integer> code;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String[] tmp = st.nextToken().split("");
            code = new ArrayList<>();
            for (int i = 0; i < tmp.length; i++) {
                code.add(Integer.parseInt(tmp[i]));
            }

            while (check()) {}

            sb.append("#" + tc + " ");
            for (int i = 0; i < code.size(); i++) {
                sb.append(code.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean check() {
        List<Integer> newCode = new ArrayList<>();
        boolean[] isDuplicated = new boolean[code.size()];
        boolean isChanged = false;
        for (int i = 0; i < code.size() - 1; i++) {
            if (code.get(i).equals(code.get(i + 1))) {
                isDuplicated[i] = true;
                isDuplicated[i + 1] = true;
                isChanged = true;
                i += 1;
            }
        }
        for (int i = 0; i < code.size(); i++) {
            if (!isDuplicated[i]) {
                newCode.add(code.get(i));
            }
        }
        code = newCode;
        return isChanged;
    }
}
