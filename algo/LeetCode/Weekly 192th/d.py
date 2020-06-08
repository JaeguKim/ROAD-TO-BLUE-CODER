class Solution:
    def minCost(self, houses: List[int], cost: List[List[int]], m: int, n: int, target: int) -> int:
        dp = {}
        
        def recursion(i,t,p):
            key = (i,t,p)
            if t < 0:
                return float('inf')
            elif i == m:
                if t == 0:
                    return 0
                return float('inf')
            
            if key not in dp:
                if houses[i] == 0:
                    minVal = float('inf')
                    for color in range(1,n+1):
                        minVal = min(minVal,recursion(i+1,t-(p!=color),color)+cost[i][color-1])
                    dp[key] = minVal
                else:
                    dp[key] = recursion(i+1,t-(p!=houses[i]),houses[i])
            return dp[key]
        res = recursion(0,target,-1)
        return res if res < float('inf') else -1