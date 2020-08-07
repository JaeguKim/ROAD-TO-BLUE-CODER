def solution(dirs):
    curPos = (0,0)
    myHash = []
    ans = 0
    for dir in dirs:
        newPos = (0,0)
        if dir == 'U':
            newPos = (curPos[0],curPos[1]+1)
        elif dir == 'R':
            newPos = (curPos[0]+1,curPos[1])
        elif dir == 'D':
            newPos = (curPos[0],curPos[1]-1)
        elif dir == 'L':
            newPos = (curPos[0]-1,curPos[1])
        if abs(newPos[0]) <= 5 and abs(newPos[1]) <= 5:
            if [curPos,newPos] not in myHash and [newPos,curPos] not in myHash:
                myHash.append([curPos,newPos])
                ans += 1
            curPos = newPos

    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = ['ULURRDLLU','LULLLLLLU']
test(tcs)