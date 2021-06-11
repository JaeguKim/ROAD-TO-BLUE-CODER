package prob1690;

import java.util.Arrays;

class Solution {

    private int[][] dp = new int[1001][1001];

    private int dfs(int[] s, int i, int j, int sum) {
        if (i == j) return 0;
        if (dp[i][j] == 0) dp[i][j] = Math.max(sum-s[i]-dfs(s,i+1,j,sum-s[i]), sum-s[j]-dfs(s,i,j-1,sum-s[j]));
        return dp[i][j];
    }

    public int stoneGameVII(int[] stones) {
        return dfs(stones,0,stones.length-1, Arrays.stream(stones).sum());
    }
}