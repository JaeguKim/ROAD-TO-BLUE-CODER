from collections import defaultdict

N = int(input())
map = [[0]*N for _ in range(N)]
startPos = (0,0)
offset = [[0,1],[1,0],[0,-1],[-1,0]] # 동,서,남,북 방향의 offset
for i in range(N):
    row = input().split(' ')
    for j in range(N):
        if int(row[j]) == 9: # 시작 지점 세팅
            startPos = (i,j)
        map[i][j] = int(row[j])
que = []
que.append((startPos,0))
map[startPos[0]][startPos[1]] = 0
ans = 0
sharkSize = 2
cntOfEat = 0

while True:
    visited = defaultdict(int) # 방문한 위치를 저장
    candidatePos = [] # 먹을수 있는 물고기 위치, 거리 저장 Eg. ( (1,3) , 3) : 물고기 위치 -> (1,3) , 거리 -> 3

    while len(que) > 0:
        curPos = que[0][0] # 물고기 위치 eg. (1,3)
        curDist = que[0][1]# 거리 eg. 3
        que.pop(0)
        for i in range(4):
            newR = curPos[0]+offset[i][0]
            newC = curPos[1]+offset[i][1]
            if newR >= 0 and newR < N and newC >= 0 and newC < N and visited[(newR,newC)] == 0:
                if map[newR][newC] == 0 or map[newR][newC] == sharkSize: # 지나갈수 있는 케이스
                    que.append(((newR,newC),curDist+1)) # 현재 위치와 현재까지 이동거리 저장
                elif map[newR][newC] < sharkSize: # 먹을 수 있는 케이스
                    candidatePos.append(((newR,newC),curDist+1)) # 먹을수 있는 물고기 위치 저장 
                visited[(newR,newC)] = 1 
    if len(candidatePos) == 0: # 더이상 먹을수 있는 물고기가 없을때 종료
        break 
    sortedPos = sorted(candidatePos,key=lambda x:(x[1],x[0][0],x[0][1])) # 거리가 가까운 순, 거리가 같으면 왼쪽에 위치한 순서, 그것마저 같다면 위쪽에 있는 순서로 정렬
    closest = sortedPos[0] # 가장 가까운 지점의 (위치, 거리)
    ans = closest[1] # 가장 가까운 지점의 거리
    closestPos = closest[0] # 가장 가까운 지점의 위치
    map[closestPos[0]][closestPos[1]] = 0 # 빈칸으로 표시
    cntOfEat += 1
    if cntOfEat == sharkSize: # 자신의 사이즈만큼 먹으면 사이즈 증가
        cntOfEat = 0
        sharkSize += 1
    que = [closest] # 큐를 수정
print(ans)

