from collections import defaultdict

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        h = defaultdict(int)
        for i,num in enumerate(nums):
            if h[target-num] != 0:
                return [i,nums.index(target-num)]
            h[num] += 1
        return []
            