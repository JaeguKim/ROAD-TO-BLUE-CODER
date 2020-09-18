# 문제를 풀때 바운더리에 유의하자
from collections import defaultdict
class Solution:

    def getNextDir(self,dir):
        return (dir+1)%4

    def getCount(self):
        ans = 0
        for i in range(0,100):
            for j in range(0,100):
                if (i,j) in self.visited and (i,j+1) in self.visited and (i+1,j) in self.visited and (i+1,j+1) in self.visited:
                    ans += 1
        return ans

    def solve(self):
        self.N = int(input())
        offset = {0:(0,1),1:(-1,0),2:(0,-1),3:(1,0)}
        self.visited = defaultdict(int)
        for i in range(self.N):
            stack = []
            x,y,d,g = [int(num) for num in input().split(' ')]
            startPos = (y,x)
            endPos = (y+offset[d][0],x+offset[d][1])
            self.visited[startPos] = 1; self.visited[endPos] = 1
            stack.append(d)
            curPos = endPos
            for _ in range(g):
                size = len(stack)
                for j in range(size-1,-1,-1):
                    prevDir = stack[j]
                    newDir = self.getNextDir(prevDir)
                    newOffset = offset[newDir]
                    newPos = (curPos[0]+newOffset[0],curPos[1]+newOffset[1])
                    curPos = newPos
                    self.visited[newPos] = 1
                    stack.append(newDir)
        res = self.getCount()
        print(res)


sol = Solution()
sol.solve()