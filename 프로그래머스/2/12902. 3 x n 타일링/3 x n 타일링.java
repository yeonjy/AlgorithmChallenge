class Solution {
    public int solution(int n) {
        long[] dp = new long[n];
        long[] sum = new long[n];
        dp[1] = 3L;
        dp[3] = 11L;
        sum[1] = dp[1];
        sum[3] = dp[3] + dp[1];
        
        for (int i = 5; i < n; i += 2) {
            dp[i] = (dp[i - 2] * 3 + sum[i - 4] * 2 + 2) % 1000000007;
            sum[i] = sum[i - 2] + dp[i];
        }
        return (int) dp[n - 1];
    }
}