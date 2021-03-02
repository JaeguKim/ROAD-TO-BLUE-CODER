class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        N = len(prices)
        if N == 0:
            return 0
        ans = 0
        firstTransDP = [0]*N; secondTransDP = [0]*N
        pMin = prices[0]; pMax = -1
        leftTransProfit = 0; rightTransProfit = 0
        for i in range(N):
            pMin = min(pMin,prices[i])
            leftTransProfit = max(leftTransProfit,prices[i]-pMin)
            firstTransDP[i] = leftTransProfit
            pMax = max(pMax,prices[N-1-i])
            rightTransProfit = max(rightTransProfit,pMax-prices[N-1-i])
            secondTransDP[N-1-i] = rightTransProfit
        for i in range(N):
            ans = max(ans,firstTransDP[i]+secondTransDP[i])
        return ans