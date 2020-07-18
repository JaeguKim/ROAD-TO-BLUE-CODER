# TIME : 2hour
def solution(board):
    offsets = [[0,1],[0,-1],[1,0],[-1,0]]
    que = []
    start = [0,0,0,[],0]; start[3].append([0,0])
    N = len(board); MAX = N*N*500
    minAry = []
    for i in range(N):
        lst = []
        for j in range(N):
            lst.append(MAX)
        minAry.append(lst)

    ans = MAX
    que.append(start)
    while len(que)!= 0:
        cur = que[0]
        que.pop(0)
        prevR = cur[0]; prevC = cur[1]; prevCost = cur[2]; visited = cur[3]; prevDir = cur[4]
        for offset in offsets:
            newR = cur[0]+offset[0]; newC = cur[1]+offset[1]
            if newR < 0 or newR > N-1 or newC < 0 or newC > N-1 or board[newR][newC] == 1 or [newR,newC] in visited:
                continue
            newDir = -1 if prevR == newR else 1
            cost = 0
            dirMult = prevDir * newDir
            if dirMult == 1 or (prevR == 0 and prevC == 0):
                cost = prevCost + 100
            elif dirMult == -1:
                cost = prevCost + 500
                cost += 100

            if minAry[newR][newC]+500 > cost and cost < ans:
                minAry[newR][newC] = cost
            else:
                continue

            if newR == N-1 and newC == N-1:
                ans = min(ans,cost)
            else:
                newVisited = visited.copy()
                newVisited.append([newR,newC])
                que.append([newR,newC,cost,newVisited,newDir])
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = [
        [[0,0,0],[0,0,0],[0,0,0]],
        [[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]],
        [[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]],
        [[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]
    ]
        
test(tcs)