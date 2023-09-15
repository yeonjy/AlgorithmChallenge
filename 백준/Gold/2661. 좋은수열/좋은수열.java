import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        answer = "";
        backtracking("");

        System.out.println(answer);
    }

    static void backtracking(String tmp) {
        if (!answer.isEmpty()) {
            return;
        }

        if (tmp.length() == N) {
            answer = tmp;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (isValid(tmp + i)) {
                backtracking(tmp + i);
            }
        }
    }

    static boolean isValid(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 0; j <= num.length() - i * 2; j++) {
                if (num.substring(j, j + i).equals(num.substring(j + i, j + i * 2))) {
                    return false;
                }
            }
        }
        return true;
    }
}
