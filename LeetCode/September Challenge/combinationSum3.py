from itertools import combinations
from collections import defaultdict
class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        digits = [i for i in range(1,10)]
        combDict = defaultdict(int)
        ans = []
        for comb in combinations(digits,k):
            if sum(comb) == n:
                if combDict[comb] == 0:
                    ans.append(comb)
                    combDict[comb] = 1
        return ans


#Second Solution
class Solution:
    def searchForCombinations(self,start,remainingSum,comb):
        if len(comb) == self.k:
            if remainingSum == 0:
                self.ans.append(comb)
            return
        for i in range(start,10):
            comb.append(i)
            self.searchForCombinations(i+1,remainingSum-i,comb)
            comb.pop(-1)
        
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        self.k = k
        self.ans = []
        self.searchForCombinations(1,n,[])
        return self.ans