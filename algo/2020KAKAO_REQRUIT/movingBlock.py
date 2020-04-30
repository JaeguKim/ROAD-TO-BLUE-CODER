import sys
#sys.setrecursionlimit(10**6) # increase recursion stack level
sys.setrecursionlimit(100)

def solution(board):
    ans = 0
    cnt = 0
    startPos = [[0,0],[0,1]]
    n = len(board)
    visited = []
    moveRobot(startPos,board,n,cnt,visited,ans)
    return ans

def checkPos(curPos,board,n,visited):
    if checkBoundaray(curPos,n) == False:
        return False
    if checkWall(curPos,board) == False:
        return False
    if checkIfPrevPos(curPos,board,visited) == False:
        return False
    return True

def checkIfPrevPos(curPos,board,visited):
    if curPos[0] in visited and curPos[1] in visited:
        return False
    return True

def checkWall(curPos,board):
    for coord in curPos:
        row = coord[0]; col = coord[1]
        if board[row][col] == 1:
            return False
    return True

def checkBoundaray(curPos,n):
    for coord in curPos:
        row = coord[0]; col = coord[1]
        if not(row >= 0 and row < n and col >= 0 and col < n):
            return False
    return True

def checkIfArrived(curPos,n):
    for coord in curPos:
        if coord[0] == n-1 and coord[1] == n-1:
            return True
    return False

def deletePos(curPos,visited):
    for pos in curPos:
        if pos in visited:
            print('pos to remove'+str(pos))
            if pos == [0,0] or pos == [0,1]:    
                continue
            visited.remove(pos)
    

def moveRobot(curPos,board,n,cnt,visited,res):
    if checkPos(curPos,board,n,visited) == False:
        return
    if checkIfArrived(curPos,n):
        print(cnt)
        if res == 0:
            res = cnt
        else:
            res = min(cnt,res)
        #cnt-=1
        return
    
    cnt += 1
    print(cnt)
    for pos in curPos:
        if pos not in visited:
            visited.append(pos)
    
    print(str(curPos))
    print(visited)
    offset =[[-1,0],[1,0],[0,-1],[0,1]]
    rotate = [1,-1]

    for i in range(len(offset)):
        curOffset = offset[i]
        newPos = [[curPos[0][0]+curOffset[0],curPos[0][1]+curOffset[1]],
        [curPos[1][0]+curOffset[0],curPos[1][1]+curOffset[1]]]
        moveRobot(newPos,board,n,cnt,visited,res)

    if curPos[0][0] == curPos[1][0]:
        for r in rotate:
            if (curPos[0][0]+r < n and curPos[0][0]+r >= 0) and (curPos[1][0]+r < n and curPos[1][0]+r >= 0):
                if board[curPos[1][0]+r][curPos[1][1]]==0 and board[curPos[0][0]+r][curPos[0][1]] == 0:
                    newPos = [[curPos[0][0]+r,curPos[0][1]],curPos[0]]
                    moveRobot(newPos,board,n,cnt,visited,res)
                    newPos = [[curPos[1][0]+r,curPos[1][1]],curPos[1]]
                    moveRobot(newPos,board,n,cnt,visited,res)
    else:
        for r in rotate:
            if (curPos[0][1]+r < n and curPos[0][1]+r >= 0) and (curPos[1][1]+r < n and curPos[1][1]+r >= 0):
                if board[curPos[1][0]][curPos[1][1]+r]==0 and board[curPos[0][0]][curPos[0][1]+r] == 0:
                    newPos = [[curPos[0][0],curPos[0][1]+r],curPos[0]]
                    moveRobot(newPos,board,n,cnt,visited,res)
                    newPos = [[curPos[1][0],curPos[1][1]+r],curPos[1]]
                    moveRobot(newPos,board,n,cnt,visited,res)

    cnt-=1

print(solution([[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]))
   

    
    
