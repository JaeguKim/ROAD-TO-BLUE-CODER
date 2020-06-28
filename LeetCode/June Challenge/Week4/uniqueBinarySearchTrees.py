class Solution:
    def numTrees(self, n: int) -> int:
        dp = [0]*(n+1)
        dp[0] = 1
        for i in range(1,n+1):
            for j in range(i):
                dp[i] += dp[j]*dp[i-j-1]
        #print(n)
        #print(dp)
        return dp[n]

def test(testCases):
    sol = Solution()
    for tc in testCases:
        res = sol.numTrees(tc)
        print(res)

testCases = [0,1,2,3,4,5]
test(testCases)