import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        lcs(str1, str2);
        System.out.println(getLcsString(str1, str1.length(), str2.length()).reverse());

    }

    static void lcs(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();

        dp = new int[str1Len + 1][str2Len + 1];
        for(int i = 1; i <= str1Len; i++) {
            for(int j = 1; j <= str2Len; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[str1Len][str2Len]);
    }

    static StringBuffer getLcsString(String str1, int str1Len, int str2Len) {
        StringBuffer sbuf = new StringBuffer();
        while (str1Len > 0 && str2Len > 0) {
            if (dp[str1Len][str2Len] == dp[str1Len - 1][str2Len]) {
                str1Len--;
            } else if (dp[str1Len][str2Len] == dp[str1Len][str2Len - 1]) {
                str2Len--;
            } else {
                sbuf.append(str1.charAt(str1Len - 1));
                str1Len--;
                str2Len--;
            }
        }
        return sbuf;
    }

}
