from collections import defaultdict

class Solution:
    def isSameParent(self,n1,n2):
        p1 = self.findParent(n1)
        p2 = self.findParent(n2)
        if p1 == p2:
            return True
        else:
            return False

    def findParent(self,node):
        if self.parent[node] == node:
            return node
        else:
            self.parent[node] = self.findParent(self.parent[node])
            return self.parent[node]

    def union(self,n1,n2):
        n1 = self.findParent(n1)
        n2 = self.findParent(n2)
        if n1 != n2:
            self.parent[n2] = n1

    def bfs(self,r,c):
        que = []
        que.append((r,c,self.sectionCnt))
        self.section[r][c] = self.sectionCnt
        self.sectionCnt += 1

        while len(que) != 0:
            item = que[0]
            que.pop(0)
            r = item[0]; c = item[1]; curSection = item[2]
            curHeight = self.land[r][c]
            for k in range(4):
                newR = r+self.dx[k]; newC = c+self.dy[k]
                if newR >= 0 and newR < self.N and newC >= 0 and newC < self.N:
                    if self.section[newR][newC] != -1:
                        continue
                    diff = abs(self.land[newR][newC]-curHeight)
                    if diff <= self.height:
                        self.section[newR][newC] = curSection
                        que.append((newR,newC,curSection))

    def getDistInfo(self):
        costDict = defaultdict(int)
        for r in range(self.N):
            for c in range(self.N):
                startSection = self.section[r][c]
                for k in range(4):
                    newR = r+self.dx[k]; newC = c+self.dy[k]
                    if newR >= 0 and newR <self. N and newC >= 0 and newC < self.N:
                        endSection = self.section[newR][newC]
                        if startSection < endSection:
                            diff = abs(self.land[r][c]-self.land[newR][newC])
                            minHeight = costDict[(startSection,endSection)]
                            #print('diff : {}, minHeight : {}, start : {}, end : {}'.format(diff,minHeight,startSection,endSection))
                            if minHeight == 0:
                                costDict[(startSection,endSection)] = diff
                            else:
                                costDict[(startSection,endSection)] = min(minHeight,diff)
        return costDict

    def solve(self,land, height):
        self.N = len(land)
        self.land = land
        self.sectionCnt = 1
        self.section = []
        self.height = height
        self.dx = [-1,0,1,0]; self.dy = [0,1,0,-1]
        for i in range(self.N):
            newList = [-1]*self.N
            self.section.append(newList)
        for r in range(self.N):
            for c in range(self.N):
                if self.section[r][c] == -1:
                    self.bfs(r,c)
        costDict = self.getDistInfo()
        sortedDict = sorted(costDict.items(),key=lambda x : x[1])
        ans = 0
        self.parent = [0]*(self.sectionCnt)
        for i in range(1,self.sectionCnt):
            self.parent[i] = i
        print(self.parent)
        for tup in sortedDict:
            n1 = tup[0][0]; n2 = tup[0][1]
            if self.isSameParent(n1,n2) == False:
                self.union(n1,n2)
                ans += tup[1]
        
        return ans

def solution(land, height):
    sol = Solution()
    ans = sol.solve(land,height)
    return ans

tcs = [
    [[[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]],3],
    [[[10, 11, 10, 11], [2, 21, 20, 10], [1, 20, 21, 11], [2, 1, 2, 1]],1]
]

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1])
        print(res)

test(tcs)
