class Solution {
    public int solution(int n) {
                if (n <= 3) {
            return n;
        }
        
        long[] dp;
        dp = new long[n + 1];
        dp[1] = 1L;
        dp[2] = 2L;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007L;
        }

        return (int) dp[n];
    }
}