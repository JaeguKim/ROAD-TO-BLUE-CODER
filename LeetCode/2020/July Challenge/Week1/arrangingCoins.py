#TIME : 07:44
from math import sqrt
class Solution:
    def arrangeCoins(self, n: int) -> int:
        res = int((-1+sqrt(1+8*n))//2)
        return res

def test(tcs):
    sol = Solution()
    for tc in tcs:
        res = sol.arrangeCoins(tc)
        print(res)
    
tcs = [0,5,8]
test(tcs)