from collections import defaultdict
from itertools import combinations
from copy import deepcopy
class Solution:
    
    def getEnemyPos(self):
        enemyInfoDict = defaultdict(int)
        for i in range(self.n):
            for j in range(self.m):
                if self.map[i][j] == 1:
                    enemyInfoDict[(i,j)] = 1
        return enemyInfoDict

    def checkBound(self,r,c):
        if r < 0 or r > self.n-1 or c < 0 or c > self.m-1:
            return False
        return True
        
    def getArcherPosPools(self):
        posPool = []
        for j in range(self.m):
            posPool.append((self.n,j))
        return posPool

    def getArcherPositions(self,posPool,idexes):
        positions = []
        for idx in idexes:
            positions.append(posPool[idx])
        return positions
    
    def getClosestEnemy(self,localEnemyInfo,archerPos):
        distanceAndPosInfo = self.getDistanceAndPosOfEnemy(localEnemyInfo,archerPos)
        if len(distanceAndPosInfo) == 0:
            return ()
        choice = sorted(distanceAndPosInfo, key=lambda x:(x[0],x[2]))[0]
        return (choice[1],choice[2])
    
    def getDistanceAndPosOfEnemy(self,localEnemyInfo,archerPos):
        distanceAndPosInfo = []
        for enemyPos in localEnemyInfo:
            dist = abs(archerPos[0]-enemyPos[0]) + abs(archerPos[1]-enemyPos[1])
            if dist <= self.d:
                distanceAndPosInfo.append((dist,enemyPos[0],enemyPos[1]))
        return distanceAndPosInfo
    
    def updateLocalEnemyInfo(self,localEnemyInfo,enemyToKillDict):
        for enemyInfo in enemyToKillDict:
            localEnemyInfo.pop(enemyInfo)
        
        enemyInfoToDelete = [] 
        enemyInfoToAdd = []
        for enemyInfo in localEnemyInfo:
            enemyInfoToDelete.append(enemyInfo)
            newEnemyInfo = (enemyInfo[0]+1,enemyInfo[1])
            if self.checkBound(newEnemyInfo[0],newEnemyInfo[1]):
                enemyInfoToAdd.append(newEnemyInfo)
        for enemyInfo in enemyInfoToDelete:
            localEnemyInfo.pop(enemyInfo)
        for enemyInfo in enemyInfoToAdd:
            localEnemyInfo[enemyInfo] = 1
        
    def solve(self):
        self.n,self.m,self.d = [int(num) for num in input().split()]
        self.map = []
        ans = 0
        for _ in range(self.n):
            self.map.append([int(num) for num in input().split()])
        originEnemyInfoDict = self.getEnemyPos()
        posPool = self.getArcherPosPools()
        posPoolIdx = [i for i in range(self.m)]
        for indexes in list(combinations(posPoolIdx,3)):
            archerPositions = self.getArcherPositions(posPool,indexes)
            localAns = 0
            localEnemyInfo = deepcopy(originEnemyInfoDict)
            while len(localEnemyInfo) > 0:
                enemyToKillDict = defaultdict(int)
                for archerPos in archerPositions:
                    closestEnemy = self.getClosestEnemy(localEnemyInfo,archerPos)
                    if closestEnemy != ():
                        enemyToKillDict[closestEnemy] = 1
                localAns += len(enemyToKillDict)
                self.updateLocalEnemyInfo(localEnemyInfo,enemyToKillDict)
            ans = max(ans,localAns)
        print(ans)   
                    
Solution().solve()