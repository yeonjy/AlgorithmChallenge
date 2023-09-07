import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int ZERO = 0;

    static int L;
    static int C;
    static int voCnt;
    static int coCnt;
    static String[] alphas;
    static String[] password;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    static List<String> volwels = Arrays.asList("a", "e", "i", "o", "u");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphas = new String[C];
        isVisited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphas[i] = st.nextToken();
        }
        Arrays.sort(alphas);
        password = new String[L];

        backtracking(ZERO, ZERO);
        System.out.println(sb);
    }

    static void backtracking(int cnt, int index) {
        if (cnt == L) {
            if (isValid()) {
                printPassword();
            }
            return;
        }
        for (int i = index; i < C; i++) {
            if (isVowel(alphas[i])) {
                voCnt++;
                password[cnt] = alphas[i];
                backtracking(cnt + 1, i + 1);
                voCnt--;
            } else {
                coCnt++;
                password[cnt] = alphas[i];
                backtracking(cnt + 1, i + 1);
                coCnt--;
            }
        }
    }

    static boolean isValid() {
        return voCnt >= 1 && coCnt >= 2;
    }

    static void printPassword() {
        for (String i : password) {
            sb.append(i);
        }
        sb.append("\n");
    }

    static boolean isVowel(String alpha) {
        return volwels.contains(alpha);
    }
}
