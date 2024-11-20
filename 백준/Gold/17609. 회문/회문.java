import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String word = br.readLine();

            if (isPalindrome(word)) {
                sb.append(0 + "\n");
            } else if (isSimilarPalindrome(word)) {
                sb.append(1 + "\n");
            } else {
                sb.append(2 + "\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        if (word.equals(reversed)) {
            return true;
        }
        return false;
    }

    static boolean isSimilarPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                StringBuilder delLeft = new StringBuilder(word).deleteCharAt(left);
                StringBuilder delRight = new StringBuilder(word).deleteCharAt(right);
                if (delLeft.toString().equals(delLeft.reverse().toString()) || delRight.toString().equals(delRight.reverse().toString())) {
                    return true;
                }
                return false;
            }
            left++;
            right--;
        }
        return false;
    }
}
