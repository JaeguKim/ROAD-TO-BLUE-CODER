#문제를 신중하게 해석했더라면 30분정도로 풀수 있는 문제였다.
#기본적인 dfs문제였는데 bfs로 해석해서 시간이 지체되었다.
from collections import defaultdict
class Solution:
    def dfs(self,pos,pathLength):
        if pos[0] == self.endPos[0] and pos[1] == self.endPos[1]:
            if pathLength == self.cntOfBlank+2:
                self.res += 1
            self.visited[self.endPos] = 0
            return
        for i in range(4):
            newPos = (pos[0]+self.offset[i][0],pos[1]+self.offset[i][1])
            if newPos[0] >= 0 and newPos[0] < self.n and newPos[1] >= 0 and newPos[1] < self.m and self.visited[newPos] == 0:
                if self.grid[newPos[0]][newPos[1]] != -1:
                    self.visited[newPos] = 1
                    self.dfs(newPos,pathLength+1)
                    self.visited[newPos] = 0
                    
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        self.grid = grid
        self.n = len(grid); self.m = len(grid[0])
        self.offset = [(0,1),(1,0),(0,-1),(-1,0)]
        startPos = []
        self.endPos = []
        self.cntOfBlank = 0
        for i in range(self.n):
            for j in range(self.m):
                if grid[i][j] == 1:
                    startPos = (i,j)
                elif grid[i][j] == 2:
                    self.endPos = (i,j)
                elif grid[i][j] == 0:
                    self.cntOfBlank += 1
        self.visited = defaultdict(int)
        self.visited[startPos] = 1
        self.res = 0
        self.dfs(startPos,1)
        return self.res  