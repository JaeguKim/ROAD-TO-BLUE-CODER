from collections import defaultdict
from copy import deepcopy

class Solution:
    
    def checkBound(self,r,c):
        if r < 0 or r > self.n-1 or c < 0 or c > self.n-1:
            return False
        return True
    
    def swap(self,pos1,pos2):
        temp = self.map[pos1[0]][pos1[1]]
        self.map[pos1[0]][pos1[1]] = self.map[pos2[0]][pos2[1]]
        self.map[pos2[0]][pos2[1]] = temp
   
    def getSameInRow(self,r,c):
        color = self.map[r][c]
        res = 1
        for i in range(c+1,self.n):
            if color == self.map[r][i]:
               res += 1
            else:
                break
        
        for i in range(c-1,-1,-1):
            if color == self.map[r][i]:
                res += 1 
            else:
                break
        
        return res
    
    def getSameInCol(self,r,c):
        color = self.map[r][c]
        res = 1
        for i in range(r+1,self.n):
            if color == self.map[i][c]:
                res += 1
            else:
                break
        
        for i in range(r-1,-1,-1):
            if color == self.map[i][c]:
                res += 1
            else:
                break
        return res
                
    def getCnt(self,r,c):
        return max(self.getSameInRow(r,c),self.getSameInCol(r,c))
     
    def bruteForce(self):
        for i in range(self.n):
            for j in range(self.n):
               localAns = self.getCnt(i,j)
               self.ans = max(self.ans,localAns)
        
    def solve(self):
        self.n = int(input())
        self.map = [list(input()) for _ in range(self.n)]
        self.offset = [(0,1),(1,0),(0,-1),(-1,0)]
        self.ans = 0
        for i in range(self.n):
            for j in range(self.n):
                for k in range(3):
                    newPos = (i+self.offset[k][0],j+self.offset[k][1])
                    if self.checkBound(newPos[0],newPos[1]) and self.map[i][j] != self.map[newPos[0]][newPos[1]]:
                        self.swap((i,j),newPos)
                        self.bruteForce()
                        self.swap((i,j),newPos)
                        
        print(self.ans)
    
Solution().solve()