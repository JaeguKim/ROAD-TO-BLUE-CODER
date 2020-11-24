from collections import Counter
#정답이 되는 수열의 길이는 2,4,6,...
#집합들간에 교집합의 원소의 갯수는 1개이상
#집합안에 원소들은 서로 다르다
import unittest

class TestStringMethods(unittest.TestCase):

    def testSolution(self):
        self.assertEqual(solution([[0,1,0],[1,1,1],[1,1,0],[0,1,1]]),6)
        self.assertEqual(solution([[1,0,0],[1,0,0]]),0)
        self.assertEqual(solution([[1,0,0,1,1],[0,0,0,0,0],[1,1,0,0,0],[0,0,0,0,1]]),72)

class Solution:
    
    def calc_combination(self,combi,n):
        combi[0][0] = 1
        for i in range(1,n+1):
            for j in range(n+1):
                if j == 0: combi[i][j] = 1
                elif i == j: combi[i][j] = 1
                else: combi[i][j] = combi[i-1][j-1] + combi[i-1][j]
                combi[i][j] %= self.MOD
       

    def solution(self,a):
        self.MOD = 1e7+19
        n = len(a)
        m = len(a[0])
        combi = [[0]*(n+1) for _ in range(n+1)]
        self.calc_combination(combi,n)
        oneCnts = [0]*(m+1)
        for i in range(n):
            for j in range(m):
                oneCnts[j+1] += a[i][j]
        
        dp = [[0]*(n+1) for _ in range(m+1)]
        dp[1][n-oneCnts[1]] = combi[n][oneCnts[1]]
        
        for col in range(1,m+1):
            oneCnt = oneCnts[col]
            for num in range(n+1):
                for k in range(oneCnt+1):
                    cntForOddRow = oneCnt-k
                    cntForBecomingEven = (num-k) + cntForOddRow
                    if cntForOddRow < 0 or cntForBecomingEven > n or cntForBecomingEven < 0: continue
                    numOfCase = (combi[num][k]  % self.MOD)*(combi[n-num][oneCnt-k] % self.MOD) % self.MOD
                    dp[col][cntForBecomingEven] += (dp[col-1][num] * numOfCase) % self.MOD
        return dp[m][n]
        
def solution(a):
    return Solution().solution(a)

if __name__ == '__main__':
    unittest.main()
