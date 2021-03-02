class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        currentMax = nums[0]
        currentMin = nums[0]
        ans = nums[0]
        
        for i in range(1,len(nums)):
            choice1 = nums[i]*currentMax
            choice2 = nums[i]*currentMin
            currentMax = max(max(choice1,choice2),nums[i])
            currentMin = min(min(choice1,choice2),nums[i])
            ans = max(ans,currentMax)
        return ans
            
    
                