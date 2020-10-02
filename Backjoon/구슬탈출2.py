from collections import defaultdict
from copy import deepcopy

class Solution:
    
    def simulation(self,redPos,bluePos,moveCnt,visited,map):
        if (bluePos == self.holePos):
            return
        elif (redPos == self.holePos):
            if self.globalMin == -1:
                self.globalMin = moveCnt
            else:
                self.globalMin = min(self.globalMin,moveCnt)
            return
        elif (moveCnt == 10):
            return
        
        for i in range(4):
            nextRedPos = (redPos[0]+self.offset[i][0],redPos[1]+self.offset[i][1])
            nextBluePos = (bluePos[0]+self.offset[i][0],bluePos[1]+self.offset[i][1])
            
            if self.canMove(nextRedPos,visited,map,'R',i) or self.canMove(nextBluePos,visited,map,'B',i):
                newVisited = deepcopy(visited)
                newMap = deepcopy(map)
                newRedPos,newBluePos = self.updateMap(redPos,bluePos,newMap,newVisited,i)
                self.simulation(newRedPos,newBluePos,moveCnt+1,newVisited,newMap)
        return
                
       
    def isInSameRow(self,redPos,bluePos):
        if (redPos[0] == bluePos[0]):
            return True
        return False

    def isInSameCol(self,redPos,bluePos):
        if (redPos[1] == bluePos[1]):
            return True
        return False
    
    def move(self,pos,dir,map,visited):
        r = pos[0]; c = pos[1]
        color = map[pos[0]][pos[1]]
        map[r][c] = '.'
        if dir == 0:
            for i in range(pos[1]+1,self.m):
                if map[r][i] != '.' and map[r][i] != 'O':
                    map[r][i-1] =  color
                    return (r,i-1)
                if map[r][i] == 'O':
                    return (r,i)
                visited[(r,i,color,dir)] = 1
        elif dir == 1:
            for i in range(pos[1]-1,-1,-1):
                if map[r][i] != '.' and map[r][i] != 'O':
                    map[r][i+1] =  color
                    return (r,i+1)
                if map[r][i] == 'O':
                    return (r,i)
                visited[(r,i,color,dir)] = 1
        elif dir == 2:
            for i in range(pos[0]+1,self.n):
                if map[i][c] != '.' and map[i][c] != 'O':
                    map[i-1][c] =  color
                    return (i-1,c)
                if map[i][c] == 'O':
                    return (i,c)
                visited[(i,c,color,dir)] = 1
        if dir == 3:
            for i in range(pos[0]-1,-1,-1):
                if map[i][c] != '.' and map[i][c] != 'O':
                    map[i+1][c] =  color                    
                    return (i+1,c)
                if map[i][c] == 'O':
                    return (i,c)
                visited[(i,c,color,dir)] = 1
        
    
    def updateMap(self,redPos,bluePos,map,visited,dir):
        newBluePos = (); newRedPos = ()
        if dir == 0 and self.isInSameRow(redPos,bluePos):
            if redPos[1] < bluePos[1]:
                newBluePos = self.move(bluePos,dir,map,visited)
                newRedPos = self.move(redPos,dir,map,visited)
            else:
                newRedPos = self.move(redPos,dir,map,visited)
                newBluePos = self.move(bluePos,dir,map,visited)
        elif dir == 1 and self.isInSameRow(redPos,bluePos):
            if redPos[1] < bluePos[1]:
                newRedPos = self.move(redPos,dir,map,visited)
                newBluePos = self.move(bluePos,dir,map,visited)
            else:
                newBluePos = self.move(bluePos,dir,map,visited)
                newRedPos = self.move(redPos,dir,map,visited)
        elif dir == 2 and self.isInSameCol(redPos,bluePos):
            if redPos[0] < bluePos[0]:
                newBluePos = self.move(bluePos,dir,map,visited)
                newRedPos = self.move(redPos,dir,map,visited)
            else:
                newRedPos = self.move(redPos,dir,map,visited)
                newBluePos = self.move(bluePos,dir,map,visited)
        elif dir == 3 and self.isInSameCol(redPos,bluePos):
            if redPos[0] < bluePos[0]:
                newRedPos = self.move(redPos,dir,map,visited)
                newBluePos = self.move(bluePos,dir,map,visited)
            else:
                newBluePos = self.move(bluePos,dir,map,visited)   
                newRedPos = self.move(redPos,dir,map,visited)
        else:
            newRedPos = self.move(redPos,dir,map,visited)
            newBluePos = self.move(bluePos,dir,map,visited)
            
        return (newRedPos,newBluePos)
    
    def canMove(self,pos,visited,map,color,dir):
        key = (pos[0],pos[1],color,dir)
        if visited[key] == 0 and map[pos[0]][pos[1]] != '#':
            return True
        return False
    
    def solve(self):
        self.n,self.m = [int(num) for num in input().split()]
        map = [list(input()) for _ in range(self.n)]
        redPos = (); bluePos = (); self.holePos = ()
        self.offset = [(0,1),(0,-1),(1,0),(-1,0)]
        for i in range(self.n):
            for j in range(self.m):
                if map[i][j] == 'B':    
                    bluePos = (i,j)
                elif map[i][j] == 'R':
                    redPos = (i,j)
                elif map[i][j] == 'O':
                    self.holePos = (i,j)
        self.globalMin = -1
        self.simulation(redPos,bluePos,0,defaultdict(int),map)
        print(self.globalMin)
Solution().solve()
