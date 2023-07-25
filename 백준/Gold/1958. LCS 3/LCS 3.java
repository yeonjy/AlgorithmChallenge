import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();


        System.out.println(calculate(str1, str2, str3));
    }

    static int calculate(String str1, String str2, String str3) {
        int[][][] dp = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    for (int k = 1; k <= str3.length(); k++) {
                        if (str2.charAt(j - 1) == str3.charAt(k - 1)) {
                            dp[i][j][k] = dp[i - 1][j - 1][k -1] + 1;
                        } else {
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                        }
                    }
                } else {
                    for (int k = 1; k <= str3.length(); k++) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }
        return dp[str1.length()][str2.length()][str3.length()];
    }

}
