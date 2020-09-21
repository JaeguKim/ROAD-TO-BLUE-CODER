from collections import defaultdict

# 1: up, 2: down, 3: left, 4: right
class Solution:
    
    def solve(self):
        n,m,k = [int(item) for item in input().split()]
        map = []
        posDict = defaultdict(list)
        scentDict = defaultdict(list)
        offsetDict = {1:(-1,0),2:(1,0),3:(0,-1),4:(0,1)}
        for i in range(n):
            map.append([0]*n)

        for i in range(n):
            row = [int(item) for item in input().split()]
            for j in range(n):
                if row[j] != 0:
                    posDict[row[j]] = [i,j]
                    scentDict[(i,j)] = [row[j],k]
                map[i][j] = row[j]
        
        dirs = [int(item) for item in input().split()]
        for i in range(m):
            posDict[i+1].append(dirs[i])    
        
        dirsBySharkInfo = defaultdict(list)
        for sharkNum in range(1,m+1):
            curDir = 1
            for i in range(4):
                searchDir = [int(item) for item in input().split()]
                dirsBySharkInfo[(sharkNum,curDir)] = searchDir
                curDir+=1
        
        duration = 0
        while duration < 1000:
            duration += 1
            newItem = []
            nextPosDict = defaultdict(list)
            sharkList = list(posDict.keys())
            for sharkNum in sharkList:
                curPos = posDict[sharkNum]
                curDir = curPos[2]
                nextPos = curPos.copy()
                sameScentPos = ()

                isFind = False
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
                nextPosDict[(nextPos[0],nextPos[1])].append((sharkNum,nextPos[2]))
                posDict.pop(sharkNum)

            for nextPos in nextPosDict.keys():
                survivingSharkInfo = nextPosDict[nextPos][0]
                if len(nextPosDict[nextPos]) >= 2:
                    survivingSharkInfo = sorted(nextPosDict[nextPos],key=lambda x:x[0])[0]
                survivingSharkNum = survivingSharkInfo[0]
                survivingSharkDir = survivingSharkInfo[1]
                posDict[survivingSharkNum] = [nextPos[0],nextPos[1],survivingSharkDir]
                scentDict[(nextPos[0],nextPos[1])] = [survivingSharkNum,k]                                          
                newItem.append((nextPos[0],nextPos[1]))

            #update scent
            temp = list(scentDict.keys()).copy()
            for pos in temp:
                if pos not in newItem:
                    scentDict[pos][1] -= 1
                if scentDict[pos][1] == 0:
                    scentDict.pop(pos)

            if len(posDict) == 1:
                break
            
        if len(posDict) == 1:
            print(duration)        
        else:
            print(-1)
            
Solution().solve()