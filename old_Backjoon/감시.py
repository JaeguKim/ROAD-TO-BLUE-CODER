from collections import defaultdict
from copy import copy,deepcopy
class Solution:

    #왼쪽,오른쪽,위,아래로 사각지대를 감시할수 있는지 탐색, 탐색가능하면 -1로 세팅

    #왼쪽
    def markLeft(self,cameraPos):
        r = cameraPos[0]
        for i in range(cameraPos[1]-1,-1,-1):
            if self.newMap[r][i] == 6:
                break
            if self.newMap[r][i] == 0:
                self.newMap[r][i] = -1
    
    #오른쪽
    def markRight(self,cameraPos):
        r = cameraPos[0]
        for i in range(cameraPos[1]+1,self.M,1):
            if self.newMap[r][i] == 6:
                break
            if self.newMap[r][i] == 0:
                self.newMap[r][i] = -1
    
    #위
    def markUp(self,cameraPos):
        c = cameraPos[1]
        for i in range(cameraPos[0]-1,-1,-1):
            if self.newMap[i][c] == 6:
                break
            if self.newMap[i][c] == 0:
                self.newMap[i][c] = -1
    
    #아래
    def markDown(self,cameraPos):
        c = cameraPos[1]
        for i in range(cameraPos[0]+1,self.N,1):
            if self.newMap[i][c] == 6:
                break
            if self.newMap[i][c] == 0:
                self.newMap[i][c] = -1
                
    #현재 카메라번호를 대상으로 감시할수 있는 영역 표시
    def monitor(self,cameraNum,case,cameraPos): #cameraNum : 현재 카메라 번호, case : 해당 카메라로 탐색할수 있는 경우의 수 번호, # cameraPos : 카메라 위치
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
            elif case == 2: # 착각했던 부분
                self.markLeft(cameraPos)
                self.markDown(cameraPos)
            elif case == 3: # 착각했던 부분
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
            elif case == 2: # 착각했던 부분
                self.markLeft(cameraPos)
                self.markDown(cameraPos)
                self.markRight(cameraPos)
            elif case == 3: # 착각했던 부분
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

    #카메라가 감시할수 있는 영역의 갯수 반환
    def getCount(self):
        cnt = 0
        for i in range(self.N):
            for j in range(self.M):
                if self.newMap[i][j] == -1:
                    cnt += 1
        return cnt

    #현재 카메라 idx를 대상으로 감시할수 있는 모든 경우의 수를 시도
    def bruteForce(self,idx):
        if idx > len(self.cameraInfo)-1: # 더이상 카메라를 선택할수 없으면
           # self.printMap()
            self.maxSearchCnt = max(self.maxSearchCnt,self.getCount()) # 최대로 감시할수 있는 영역갯수 갱신
            return

        cameraPos = self.cameraInfo[idx][0]
        cameraNum = self.cameraInfo[idx][1]
        for case in range(self.caseCntByCamera[cameraNum]): #현재 카메라를 대상으로 탐색할수 있는 모든 경우를 시도
            backup = deepcopy(self.newMap) #경우를 계산하기전에 백업(값이 덮어써지므로)
            self.monitor(cameraNum,case,cameraPos) #현재 case시도
            self.bruteForce(idx+1) #현재 카메라의 감시를 끝낸상태에서 다음 camera를 대상으로 감시할수 있는 경우 시도
            self.newMap = deepcopy(backup) #백업해놓은 데이터로 복구

    def solve(self):
        self.N,self.M = [int(i) for i in input().split(' ')]
        self.map = []
        hiddenSpot = 0
        self.cameraInfo = [] #camera 번호와 위치를 저장 eg. (1,3),3 : (1,3)위치에 3번 카메라
        for i in range(self.N):
            self.map.append([0]*self.M)
        for i in range(self.N):
            row = [int(i) for i in input().split(' ')]
            for j in range(self.M):
                self.map[i][j] = row[j]
                if row[j]>=1 and row[j]<=5:
                    self.cameraInfo.append(((i,j),row[j])) #카메라 정보 세팅
                elif row[j] == 0: #탐색하기전 사각지대 개수 저장
                    hiddenSpot += 1
        #print(self.cameraInfo)
        self.newMap = deepcopy(self.map) #map정보를 복사
        self.maxSearchCnt = 0 #최대로 감시할수 있는 영역개수
        self.caseCntByCamera = {1:4,2:2,3:4,4:4,5:1}  #카메라 번호에 대한 탐색가능한 경우의 수
        
        self.bruteForce(0) #첫번째 카메라부터 탐색시작, bruteForce(1),bruteForce(2),... 재귀적으로 호출되게 됨
        ans = hiddenSpot-self.maxSearchCnt #사각지대의 최소값 = 전체 빈칸 - (최대로 검색할수 있는 지점갯수)
        print(ans)

Solution().solve()