class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        N = len(prices)
        if N == 0:
            return 0
        minDp = [0]*N
        maxDp = [0]*N
        minPrice = prices[0]; maxPrice = prices[-1]
        for i in range(N):
            minPrice = min(minPrice,prices[i])
            minDp[i] = minPrice
            maxPrice = max(maxPrice,prices[N-1-i])
            maxDp[N-1-i] = maxPrice
        
        maxProfit = 0
        for i in range(N):
            maxProfit = max(maxProfit,maxDp[i]-minDp[i])
        return maxProfit