package prob322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,20000);
        for (int coin : coins) {
            if (coin <= amount)
                dp[coin] = 1;
        }
        for (int i=1; i<amount; ++i) {
            for (int coin : coins) {
                if (i+coin >= 0 && i+coin <= amount)
                    dp[i+coin] = Math.min(dp[i]+1,dp[i+coin]);
            }
        }
        return dp[amount] == 20000 ? -1 : dp[amount];
    }
}
