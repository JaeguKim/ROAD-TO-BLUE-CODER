from collections import defaultdict
class Solution:
    def getLeftDir(self,dir):
        dir -= 1
        if dir < 0:
            dir = 3
        return dir
    
    def getRightDir(self,dir):
        dir += 1
        if dir > 3:
            dir = 0
        return dir
    
    def isRobotBounded(self, instructions: str) -> bool:
        cntDict = defaultdict(int)
        offsetByDir = {0:(0,1),1:(1,0),2:(0,-1),3:(-1,0)}
        curDir = 0
        curPos = (0,0)
        for ch in instructions:
            if ch == 'L':
                curDir = self.getLeftDir(curDir)
            elif ch == 'R':
                curDir = self.getRightDir(curDir)
            elif ch == 'G':
                curPos = (curPos[0]+offsetByDir[curDir][0],curPos[1]+offsetByDir[curDir][1])
        if curPos == (0,0):
            return True
        elif curDir != 0:
            return True
        else:
            return False