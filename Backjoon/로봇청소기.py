from collections import defaultdict

class Solution:

    def inBoundary(self,row,col):
        if row < 0 or row > self.N-1 or col < 0 or col > self.M-1:
            return False
        return True

    def getNextDir(self,dir):
        dir -= 1
        if dir < 0:
            dir = 3
        return dir
    
    def solve(self):
        self.N,self.M = [int(ch) for ch in input().split(' ')]
        startPos = [int(i) for i in input().split(' ')]
        map = [[0]*self.M for _ in range(self.N)]
        for i in range(self.N):
            mapInfo = input().split(' ')
            for j in range(self.M):
                map[i][j] = int(mapInfo[j])
        offsetByDir = {
            0:[(0,1),(0,-1),(1,0),(-1,0)],
            1:[(1,0),(-1,0),(0,-1),(0,1)],
            2:[(0,-1),(0,1),(-1,0),(1,0)],
            3:[(-1,0),(1,0),(0,1),(0,-1)]
        }
        ans = 1
        cleanPos = defaultdict(int)
        curPos = (startPos[0],startPos[1],startPos[2])
        cntOfRotation = 0
        cleanPos[(curPos[0],curPos[1])] = 1
        while True:
            if cntOfRotation == 4:
                cntOfRotation = 0
                rearOffset = offsetByDir[curDir][2]
                rearPos = (curPos[0]+rearOffset[0],curPos[1]+rearOffset[1])

                if self.inBoundary(rearPos[0],rearPos[1]) and map[rearPos[0]][rearPos[1]] == 0:
                    curPos = (rearPos[0],rearPos[1],curDir)
                else:
                    break
            
            curDir = curPos[2]
            curRow = curPos[0]; curCol = curPos[1]
            leftOffset = offsetByDir[curDir][1]
            leftPos = (curRow+leftOffset[0],curCol+leftOffset[1])
            leftDir = self.getNextDir(curDir)
            curDir = leftDir
            if self.inBoundary(leftPos[0],leftPos[1]):
                if cleanPos[leftPos] == 1 or map[leftPos[0]][leftPos[1]] == 1:
                    cntOfRotation += 1
                    curPos = (curPos[0],curPos[1],leftDir)
                else:
                    ans += 1
                    cleanPos[leftPos] = 1
                    curPos = (leftPos[0],leftPos[1],leftDir)
                    cntOfRotation = 0
            else:
                cntOfRotation += 1
                curPos = (curPos[0],curPos[1],leftDir)
        print(ans)

Solution().solve()