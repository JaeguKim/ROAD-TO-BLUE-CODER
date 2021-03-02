class Solution:
    def myPow(self, x: float, n: int) -> float:
        res = pow(x,n)
        return round(res,5)

def test(tcs):
    sol = Solution()
    for tc in tcs:
        res = sol.myPow(tc[0],tc[1])
        print(res)
tcs = [[2.00000, 10],[2.10000, 3],[2.00000, -2]]
test(tcs)
