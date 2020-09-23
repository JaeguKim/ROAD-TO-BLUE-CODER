from collections import defaultdict
from copy import copy

class Solution:
    
    def getKey(self,dir):
        return self.dirDict[dir]
    
    def checkBound(self,pos):
        r = pos[0]; c = pos[1]
        if r < 0 or r > self.n-1 or c < 0 or c > self.m-1:
            return False
        return True
    
    def updateDice(self,command):
        if command == self.getKey('e'):
            self.diceDict[self.getKey('t')] = self.backup[self.getKey('w')]
            self.diceDict[self.getKey('e')] = self.backup[self.getKey('t')]
            self.diceDict[self.getKey('b')] = self.backup[self.getKey('e')]
            self.diceDict[self.getKey('w')] = self.backup[self.getKey('b')]
        elif command == self.getKey('w'):
            self.diceDict[self.getKey('t')] = self.backup[self.getKey('e')]
            self.diceDict[self.getKey('e')] = self.backup[self.getKey('b')]
            self.diceDict[self.getKey('b')] = self.backup[self.getKey('w')]
            self.diceDict[self.getKey('w')] = self.backup[self.getKey('t')]
        elif command == self.getKey('s'):
            self.diceDict[self.getKey('t')] = self.backup[self.getKey('n')]
            self.diceDict[self.getKey('n')] = self.backup[self.getKey('b')]
            self.diceDict[self.getKey('b')] = self.backup[self.getKey('s')]
            self.diceDict[self.getKey('s')] = self.backup[self.getKey('t')]
        elif command == self.getKey('n'):
            self.diceDict[self.getKey('t')] = self.backup[self.getKey('s')]
            self.diceDict[self.getKey('s')] = self.backup[self.getKey('b')]
            self.diceDict[self.getKey('b')] = self.backup[self.getKey('n')]
            self.diceDict[self.getKey('n')] = self.backup[self.getKey('t')]
    
    def solve(self):
        self.n,self.m,x,y,k = [int(num) for num in input().split()]
        self.map = []
        for _ in range(self.n):
            self.map.append([int(num) for num in input().split()])

        self.dirDict = {'e':1,'w':2,'n':3,'s':4,'t':5,'b':6}
        self.diceDict = defaultdict(int)
        offsetDict = {1:(0,1),2:(0,-1),3:(-1,0),4:(1,0)}
        curPos = (x,y)
        commands = [int(num) for num in input().split()]
        for command in commands:
            offset = offsetDict[command]
            newPos = (curPos[0]+offset[0],curPos[1]+offset[1])
            if self.checkBound(newPos):
                self.backup = copy(self.diceDict)
                self.updateDice(command)
                if self.map[newPos[0]][newPos[1]] == 0:
                    self.map[newPos[0]][newPos[1]] = self.diceDict[self.getKey('b')]
                else:
                    self.diceDict[self.getKey('b')] = self.map[newPos[0]][newPos[1]]
                    self.map[newPos[0]][newPos[1]] = 0
                curPos = newPos
                print(self.diceDict[self.getKey('t')]) 
        
Solution().solve()