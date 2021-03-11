package com.leetcode.marchchallenge.coinChange;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        for (int coin : coins) {
            if (coin < dp.length)
                dp[coin] = 1;
        }
        for (int i=1;i<=amount;i++) {
            for (int coin : coins) {
                if (i-coin >= 0 && dp[i-coin] > 0) {
                    if (dp[i] == 0) dp[i] = dp[i-coin]+1;
                    else dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        if (dp[amount] == 0) return -1;
        return dp[amount];
    }
}
