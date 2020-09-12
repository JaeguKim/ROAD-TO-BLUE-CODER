class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        global_max = nums[0]
        local_max = 0
        for num in nums:
            local_max = max(local_max+num,num)
            global_max = max(global_max,local_max)
        return global_max