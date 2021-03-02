package HouserRobber||;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        else if (n == 1) return nums[0];
        int[] dp = new int[n];
        int case1,case2;
        dp[0] = nums[0]; dp[1] = dp[0];
        for (int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        case1 = dp[n-2];
        dp[0] = 0; dp[1] = nums[1];
        for (int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        case2 = dp[n-1];
        return Math.max(case1,case2);
    }
}