package 거스름돈;

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int num : money) {
            for (int i=1;i<=n;i++){
                if (i - num >= 0) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[n];
    }
}