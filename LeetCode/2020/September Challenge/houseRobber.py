class Solution:
    def rob(self, nums: List[int]) -> int:
        N = len(nums)
        dp = [0]*N
        if N == 0:
            return 0
        elif N < 3:
            return max(nums)
        else:
            dp[0] = nums[0]; dp[1] = max(nums[0],nums[1])
            for i in range(2,N):
                dp[i] = max(nums[i]+dp[i-2],dp[i-1])
        
        return dp[N-1]