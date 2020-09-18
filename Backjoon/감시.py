from collections import defaultdict
from copy import copy,deepcopy
class Solution:

    def markLeft(self,cameraPos):
        r = cameraPos[0]
        for i in range(cameraPos[1]-1,-1,-1):
            if self.newMap[r][i] == 6:
                break
            if self.newMap[r][i] == 0:
                self.newMap[r][i] = -1
    
    def markRight(self,cameraPos):
        r = cameraPos[0]
        for i in range(cameraPos[1]+1,self.M,1):
            if self.newMap[r][i] == 6:
                break
            if self.newMap[r][i] == 0:
                self.newMap[r][i] = -1
    
    def markUp(self,cameraPos):
        c = cameraPos[1]
        for i in range(cameraPos[0]-1,-1,-1):
            if self.newMap[i][c] == 6:
                break
            if self.newMap[i][c] == 0:
                self.newMap[i][c] = -1
    
    def markDown(self,cameraPos):
        c = cameraPos[1]
        for i in range(cameraPos[0]+1,self.N,1):
            if self.newMap[i][c] == 6:
                break
            if self.newMap[i][c] == 0:
                self.newMap[i][c] = -1
                
    
    def monitor(self,cameraNum,case,cameraPos):
        if cameraNum == 1:
            if case == 0:
                self.markRight(cameraPos)
            elif case == 1:
                self.markDown(cameraPos)
            elif case == 2:
                self.markLeft(cameraPos)
            elif case == 3:
                self.markUp(cameraPos)
        elif cameraNum == 2:
            if case == 0:
                self.markLeft(cameraPos)
                self.markRight(cameraPos)
            elif case == 1:
                self.markUp(cameraPos)
                self.markDown(cameraPos)
        elif cameraNum == 3:
            if case == 0:
                self.markUp(cameraPos)
                self.markRight(cameraPos)
            elif case == 1:
                self.markRight(cameraPos)
                self.markDown(cameraPos)
            elif case == 2:
                self.markLeft(cameraPos)
                self.markDown(cameraPos)
            elif case == 3:
                self.markLeft(cameraPos)
                self.markUp(cameraPos)
        elif cameraNum == 4:
            if case == 0:
                self.markLeft(cameraPos)
                self.markUp(cameraPos)
                self.markRight(cameraPos)
            elif case == 1:
                self.markUp(cameraPos)
                self.markRight(cameraPos)
                self.markDown(cameraPos)
            elif case == 2:
                self.markLeft(cameraPos)
                self.markDown(cameraPos)
                self.markRight(cameraPos)
            elif case == 3:
                self.markUp(cameraPos)
                self.markLeft(cameraPos)
                self.markDown(cameraPos)
        elif cameraNum == 5:
            self.markUp(cameraPos)
            self.markRight(cameraPos)
            self.markDown(cameraPos)
            self.markLeft(cameraPos)

    def printMap(self):
        print('==================')
        for i in range(self.N):
            for j in range(self.M):
                print(self.newMap[i][j],end=' ')
            print()
        print('==================')

    def getCount(self):
        cnt = 0
        for i in range(self.N):
            for j in range(self.M):
                if self.newMap[i][j] == -1:
                    cnt += 1
        return cnt

    def bruteForce(self,idx):
        if idx > len(self.cameraInfo)-1:
           # self.printMap()
            self.maxSearchCnt = max(self.maxSearchCnt,self.getCount())
            return

        cameraPos = self.cameraInfo[idx][0]
        cameraNum = self.cameraInfo[idx][1]
        for case in range(self.caseCntByCamera[cameraNum]):
            backup = deepcopy(self.newMap)
            self.monitor(cameraNum,case,cameraPos)
            self.bruteForce(idx+1)
            self.newMap = deepcopy(backup)

    def solve(self):
        self.N,self.M = [int(i) for i in input().split(' ')]
        self.map = []
        hiddenSpot = 0
        self.cameraInfo = []
        for i in range(self.N):
            self.map.append([0]*self.M)
        for i in range(self.N):
            row = [int(i) for i in input().split(' ')]
            for j in range(self.M):
                self.map[i][j] = row[j]
                if row[j]>=1 and row[j]<=5:
                    self.cameraInfo.append(((i,j),row[j]))
                elif row[j] == 0:
                    hiddenSpot += 1
        #print(self.cameraInfo)
        self.newMap = deepcopy(self.map)
        self.maxSearchCnt = 0
        self.caseCntByCamera = {1:4,2:2,3:4,4:4,5:1}
        
        self.bruteForce(0)
        ans = hiddenSpot-self.maxSearchCnt
        print(ans)

Solution().solve()