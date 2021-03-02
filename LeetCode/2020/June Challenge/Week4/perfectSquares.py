#In Python, **n is faster than x*x...*x when exponent is large
#On the other hand, x*x...*x is fater than **n when exponenet is small
from math import sqrt,floor
class Solution:
    def numSquares(self, n: int) -> int:
        dp = [0]*(n+1)
        for i in range(1,floor(sqrt(n))+1):
            dp[i*i] = 1
        for i in range(1,n+1):
            if dp[i] == 0:
                n1 = floor(sqrt(i))
                minVal = n
                for j in range(1,n1+1):
                    temp = j*j
                    calc = dp[temp]+dp[i-temp]
                    minVal = min(minVal,calc)
                dp[i] = minVal
        #print(dp)
        return dp[n]

def test(tcs):
    sol = Solution()
    for tc in tcs:
        res = sol.numSquares(tc)
        print(res)

tcs = [12,13,6554,7168]
test(tcs)