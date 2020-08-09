class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        que = []
        cntOfFresh = 0
        cntOfRow = len(grid); cntOfCol = len(grid[0])
        dx = [-1,0,1,0]; dy = [0,1,0,-1]
        for row in range(cntOfRow):
            for col in range(cntOfCol):
                if status == 2:
                    que.append((row,col,0))
                elif status == 1:
                    cntOfFresh+=1
        cntOfTraversed = 0
        ans = -1
        while len(que)>0:
            first = que[0]
            que.pop(0)
            curRow = first[0]; curCol = first[1]; curTime = first[2]
            for i in range(4):
                newR = curRow+dx[i]; newC = curCol+dy[i]
                if newR > -1 and newR < cntOfRow and newC > -1 and newC < cntOfCol:
                    if grid[newR][newC] == 1:
                        que.append((newR,newC,curTime+1))
                        cntOfTraversed+=1
                        ans = max(ans,curTime+1)
        if cntOfTraversed == cntOfFresh:
            return ans
        else:
            return -1
