class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        ans = numBottles
        empty = numBottles;
        full = 0        
        while empty >= numExchange:
            full = empty//numExchange
            ans += full
            empty = empty%numExchange
            empty += full
        return ans

def test(tcs):
    sol = Solution()
    for tc in tcs:
        res = sol.numWaterBottles(tc[0],tc[1])
        print(res)

tcs = [[15,4],[5,5],[2,3],[1,2],]
test(tcs)