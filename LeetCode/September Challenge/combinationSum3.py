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
