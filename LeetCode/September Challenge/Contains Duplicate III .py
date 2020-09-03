class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:

        if t == 0 and len(nums) == len(set(nums)):
            return False
        
        N = len(nums)
        
        for idx,val in enumerate(nums):
            for j in range(idx+1,min(idx+1+k,N)):
                if abs(val-nums[j]) <= t:
                    return True
        
        return False