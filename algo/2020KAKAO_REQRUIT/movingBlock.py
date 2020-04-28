def solution(board):
    ans = 0
    startPos = [[0,0],[0,1]]
    n = len(board)
    moveRobot(startPos,board,n,ans)
    return ans

def checkPos(curPos,board,n):
    if checkBoundray(curPos,n) == False:
        return False
    if checkWall(curPos,board) == False:
        return False
    if checkIfPrevPos(curPos,board) == False:
        return False
    return True

def checkIfPrevPos(curPos,board):
    for coord in curPos:
        row = coord[0]; col = coord[1]
        if board[row][col] != -1:
            return True
    return False

def checkWall(curPos,board):
    for coord in curPos:
        row = coord[0]; col = coord[1]
        if board[row][col] == 1:
            return False
    return True

def checkBoundray(curPos,n):
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

def markBoard(newPos,board):
    for coord in newPos:
        row = coord[0]
        col = coord[1]
        board[row][col] = -1

def demarkBoard(newPos,board):
    for coord in newPos:
        row = coord[0]
        col = coord[1]
        board[row][col] = 0

def moveRobot(curPos,board,n,res):
    if checkPos(curPos,board,n) == False:
        return
    if checkIfArrived(curPos,n):
        res += 1
        return
    print(str(curPos))
    markBoard(curPos,board)
    offset =[[[-1,0],[-1,0]], [[1,0],[1,0]], [[0,-1],[0,-1]], [[0,1],[0,1]],[[0,0],[-1,-1]],
    [[0,0],[1,-1]],[[-1,1],[0,0]],[[1,1],[0,0]]]

    for i in range(len(offset)):
        curOffset = offset[i]
        #print('curOffset : ' +str(curOffset))
        newPos = [[curPos[0][0]+curOffset[0][0],curPos[0][1]+curOffset[0][1]],
        [curPos[1][0]+curOffset[1][0],curPos[1][1]+curOffset[1][1]]]
        moveRobot(newPos,board,n,res)
    
    demarkBoard(curPos,board)

print(solution([[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]))
   

    
    
