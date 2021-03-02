class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        mask = 0
        maxXor = 0
        N = len(nums)
        se = set()
        
        for i in range(30,-1,-1):
            mask |= (1<<i)
            newMax = maxXor | (1<<i)
            
            for j in range(N):
                se.add(nums[j]&mask)
            
            for prefix in se:
                if prefix ^ newMax in se:
                    maxXor = newMax
                    break
            se.clear()
        
        return maxXor