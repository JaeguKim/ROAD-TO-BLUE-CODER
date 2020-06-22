from typing import List
dx = [0,1]; dy = [1,0]
class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        if len(dungeon) == 0:
            return 0
        m = len(dungeon); n = len(dungeon[0])
        sol = [[0]*n for i in range(m)]
        sol[m-1][n-1] = abs(dungeon[m-1][n-1])+1 if dungeon[m-1][n-1]<0 else 1
        for i in range(m-2,-1,-1):
            sol[i][n-1] = max(sol[i+1][n-1] - dungeon[i][n-1],1)
        for j in range(n-2,-1,-1):
            sol[m-1][j] = max(sol[m-1][j+1]-dungeon[m-1][j],1)
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                sol[i][j] = max(min(sol[i+1][j],sol[i][j+1])-dungeon[i][j],1)
        return sol[0][0]
        

def test(testCases):
    sol = Solution()
    for case in testCases:
        print(sol.calculateMinimumHP(case))

testCases = [[[-2,-3,3],[-5,-10,1],[10,30,-5]],[[0,0,0],[0,0,0]],[[-1,-1,-1,-1]],[],[[-1]],[[100]]
,[[100,100,100],[1,2,3]]]
test(testCases)
