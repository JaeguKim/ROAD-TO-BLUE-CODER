from collections import defaultdict

# 1: up, 2: down, 3: left, 4: right
class Solution:
    
    def solve(self):
        n,m,k = [int(item) for item in input().split()]
        posDict = defaultdict(list) # key : 상어번호 , value : 행,열,방향
        scentDict = defaultdict(list) # key : (행,열) , value : 상어번호,남은시간
        offsetDict = {1:(-1,0),2:(1,0),3:(0,-1),4:(0,1)}

        #초기 상어의 위치,방향,냄새정보 세팅
        for i in range(n):
            row = [int(item) for item in input().split()]
            for j in range(n):
                if row[j] != 0:
                    posDict[row[j]] = [i,j]
                    scentDict[(i,j)] = [row[j],k]
        
        dirs = [int(item) for item in input().split()]
        for i in range(m):
            posDict[i+1].append(dirs[i])    
        
        #방향에 따른 우선순위 정보 설정
        dirsBySharkInfo = defaultdict(list) # key : (상어번호,방향) , value : 방향들
        for sharkNum in range(1,m+1):
            curDir = 1
            for i in range(4):
                searchDir = [int(item) for item in input().split()]
                dirsBySharkInfo[(sharkNum,curDir)] = searchDir
                curDir+=1
        
        #최대 1000번 반복
        duration = 0
        while duration < 1000:
            duration += 1
            newItem = []
            nextPosDict = defaultdict(list) # key : (행,열), value : [(상어번호,방향), ... ]
            sharkList = list(posDict.keys())
            
            #상어들을 대상으로 다음 움직일 위치를 구하기
            for sharkNum in sharkList:
                curPos = posDict[sharkNum]
                curDir = curPos[2]
                nextPos = curPos.copy()
                sameScentPos = ()

                isFind = False
                #우선순위에따라 다음 움직일 방향을 구한다
                for dir in dirsBySharkInfo[(sharkNum,curDir)]:
                    offset = offsetDict[dir]
                    nextPos = (curPos[0]+offset[0],curPos[1]+offset[1],dir)
                    if nextPos[0] < 0 or nextPos[0] > n-1 or nextPos[1] < 0 or nextPos[1] > n-1:
                        continue
                    keyVal = (nextPos[0],nextPos[1])
                    if scentDict[keyVal] != []:
                        if scentDict[keyVal][0] == sharkNum and sameScentPos == ():
                            sameScentPos = nextPos
                    else:
                        isFind = True
                        break
    
                if isFind == False:
                    if sameScentPos == ():
                        nextPos = curPos
                    else:
                        nextPos = sameScentPos
                        
                #다음 움직일 위치에 상어번호,방향을 추가한다
                nextPosDict[(nextPos[0],nextPos[1])].append((sharkNum,nextPos[2]))
                #기존에 있는 위치정보는 삭제한다
                posDict.pop(sharkNum)

            #다음 움직일 위치정보를 보고 경쟁이 없으면 새로운 위치를 세팅, 경쟁이 있으면 번호가 낮은 상어만 새로운 위치를 세팅한다
            for nextPos in nextPosDict.keys():
                survivingSharkInfo = nextPosDict[nextPos][0]
                if len(nextPosDict[nextPos]) >= 2:
                    survivingSharkInfo = sorted(nextPosDict[nextPos],key=lambda x:x[0])[0]
                survivingSharkNum = survivingSharkInfo[0]
                survivingSharkDir = survivingSharkInfo[1]
                posDict[survivingSharkNum] = [nextPos[0],nextPos[1],survivingSharkDir]
                scentDict[(nextPos[0],nextPos[1])] = [survivingSharkNum,k]                                          
                newItem.append((nextPos[0],nextPos[1]))

            #냄새 정보를 업데이트한다
            temp = list(scentDict.keys()).copy()
            for pos in temp:
                if pos not in newItem:
                    scentDict[pos][1] -= 1
                if scentDict[pos][1] == 0:
                    scentDict.pop(pos)

            #상어가 한마리 남으면 종료한다
            if len(posDict) == 1:
                break
            
        if len(posDict) == 1:
            print(duration)        
        else:
            print(-1)
            
Solution().solve()