package prob1359;

public class Solution {
    public int countOrders(int n) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        long MOD = (long)(1e9+7);
        for (int i=2; i<=n; ++i) {
            dp[i] = (dp[i-1]*((2*i-1)*i))%MOD;
        }
        return (int)dp[n];
    }
}
