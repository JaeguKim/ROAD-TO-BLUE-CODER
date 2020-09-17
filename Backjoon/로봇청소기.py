from collections import defaultdict

class Solution:

    def inBoundary(self,row,col):
        if row < 0 or row > self.N-1 or col < 0 or col > self.M-1:
            return False
        return True

    # 다음방향 반환(왼쪽으로 회전)
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
        
        # 현재 바라보는 방향 기준으로 동,서,남,북 이동 offset 
        offsetByDir = {
            0:[(0,1),(0,-1),(1,0),(-1,0)], # 북
            1:[(1,0),(-1,0),(0,-1),(0,1)], # 동
            2:[(0,-1),(0,1),(-1,0),(1,0)], # 남
            3:[(-1,0),(1,0),(0,1),(0,-1)] # 서
        }
        ans = 1
        cleanPos = defaultdict(int)
        curPos = (startPos[0],startPos[1],startPos[2]) # (행번호, 열번호, 바라보는 방향)
        cntOfRotation = 0 # 현재 지점에 온 이후부터 회전한 횟수
        cleanPos[(curPos[0],curPos[1])] = 1 # 청소한 지점 표시
        while True:
            if cntOfRotation == 4: # 한바퀴 회전해서 다시 제자리로 돌아온 경우
                cntOfRotation = 0
                rearOffset = offsetByDir[curDir][2] # 현재방향 기준 뒤로 이동 offset
                rearPos = (curPos[0]+rearOffset[0],curPos[1]+rearOffset[1]) 

                if self.inBoundary(rearPos[0],rearPos[1]) and map[rearPos[0]][rearPos[1]] == 0: # 뒤쪽에 벽이 없으면 뒤로 이동
                    curPos = (rearPos[0],rearPos[1],curDir)
                else: # 뒤로 이동불가하면 종료
                    break
            
            curDir = curPos[2]
            curRow = curPos[0]; curCol = curPos[1]
            leftOffset = offsetByDir[curDir][1] #현재 방향 기준 왼쪽 offset
            leftPos = (curRow+leftOffset[0],curCol+leftOffset[1]) #왼쪽 방향으로 이동시 위치 계산
            leftDir = self.getNextDir(curDir) #현재 방향 기준 왼쪽 방향 계산
            curDir = leftDir
            if self.inBoundary(leftPos[0],leftPos[1]):
                if cleanPos[leftPos] == 1 or map[leftPos[0]][leftPos[1]] == 1: # 왼쪽 방향에 청소가 불가능한 경우
                    cntOfRotation += 1 # 회전횟수 증가
                    curPos = (curPos[0],curPos[1],leftDir) # 새로운 위치로 세팅
                else:
                    ans += 1 # 청소횟수 증가
                    cleanPos[leftPos] = 1 # 청소한 지점 표시
                    curPos = (leftPos[0],leftPos[1],leftDir) 
                    cntOfRotation = 0 # 회전횟수 초기화
            else: # 왼쪽방향이 경계밖으로 나가는 경우
                cntOfRotation += 1 
                curPos = (curPos[0],curPos[1],leftDir)
        print(ans)

Solution().solve()