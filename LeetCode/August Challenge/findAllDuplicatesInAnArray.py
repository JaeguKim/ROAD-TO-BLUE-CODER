from collections import defaultdict
class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        cntDict = defaultdict(int)
        mySet = set()
        for num in nums:
            cntDict[num] += 1
            if cntDict[num] > 1:
                mySet.add(num)
        return list(mySet)