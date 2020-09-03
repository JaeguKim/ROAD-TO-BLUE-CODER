from collections import defaultdict
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        hashDict = defaultdict(int)
        for num in nums:
            if hashDict[num] == 0:
                hashDict[num]=1
            else:
                return True
        return False
            