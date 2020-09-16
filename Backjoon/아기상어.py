from collections import defaultdict
N = int(input())
map = [[0]*N for _ in range(N)]
startPos = (0,0)
offset = [[0,1],[1,0],[0,-1],[-1,0]]
for i in range(N):
    row = input().split(' ')
    for j in range(N):
        if int(row[j]) == 9:
            startPos = (i,j)
        map[i][j] = int(row[j])
que = []
que.append((startPos,0))
map[startPos[0]][startPos[1]] = 0
ans = 0
sharkSize = 2
cntOfEat = 0

while True:
    visited = defaultdict(int)
    candidatePos = []

    while len(que) > 0:
       # print(que)
        curPos = que[0][0]
        curDist = que[0][1]
        que.pop(0)
        for i in range(4):
            newR = curPos[0]+offset[i][0]
            newC = curPos[1]+offset[i][1]
            if newR >= 0 and newR < N and newC >= 0 and newC < N and visited[(newR,newC)] == 0:
                #print('newR : {}, newC : {}, mapVal : {}, shartSize : {}'.format(newR,newC,map[newR][newC],sharkSize))
                if map[newR][newC] == 0 or map[newR][newC] == sharkSize:
                    que.append(((newR,newC),curDist+1))
                elif map[newR][newC] < sharkSize:
                    candidatePos.append(((newR,newC),curDist+1))
                visited[(newR,newC)] = 1
    if len(candidatePos) == 0:
        break
   # print('shark size : {}'.format(sharkSize))
   # print('candidate pos : {}'.format(candidatePos))
    sortedPos = sorted(candidatePos,key=lambda x:(x[1],x[0][0],x[0][1]))
   # print('sorted pos : {}'.format(sortedPos))
    closest = sortedPos[0]
    ans = sortedPos[0][1]
    closestPos = closest[0]
    map[closestPos[0]][closestPos[1]] = 0
    cntOfEat += 1
    if cntOfEat == sharkSize:
        cntOfEat = 0
        sharkSize += 1
    que = [closest]
print(ans)

