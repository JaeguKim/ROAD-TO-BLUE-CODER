def solution(maze):
    que = []
    N = len(maze)
    startInfo = (0,0,0)
    dirs = {(0,1):(1,0),(1,1):(1,0),(1,0):(0,-1),(1,-1):(0,-1),(0,-1):(-1,0),(-1,-1):(-1,0),(-1,0):(0,1),(-1,1):(0,1)}
    visited = {} # { (0,1) : [], (0,2) : []}
    minTime = -1
    que.append(startInfo)
    # 테두리도 wall로 처리
    while len(que) > 0:
        curInfo = que[0]
        curTime = curInfo[2]
        que.pop(0)
        #print(visited)
        if curInfo[0] == N-1 and curInfo[1] == N-1:
            if minTime == -1:
                minTime = curTime+1
            else:
                minTime = min(minTime,curTime+1)
            continue
        for dir in dirs:
            wallPos = (curInfo[0]+dir[0], curInfo[1]+dir[1])
            wall_r = wallPos[0]; wall_c = wallPos[1]
            print('dir : {}'.format(dir))
            if ((wall_r < 0 or wall_r >= N) or (wall_c < 0 or wall_c >= N)) or maze[wall_r][wall_c] == 1:
                #print('wallPos : {}'.format(wallPos))
                newPos = (curInfo[0]+ dirs[dir][0],curInfo[1]+dirs[dir][1])
                newPos_r = newPos[0]; newPos_c = newPos[1]
                #print('newPos : {}'.format(newPos))
                if (newPos_r >= 0 and newPos_r < N) and (newPos_c >= 0 and newPos_c < N) and maze[newPos_r][newPos_c] == 0:
                    if (newPos_r,newPos_c) not in visited:
                        visited[(newPos_r,newPos_c)] = {}
                    if dir not in visited[(newPos_r,newPos_c)]:
                        visited[(newPos_r,newPos_c)][dir] = 1
                        # curInfo와 새로운 위치에 따라서 판단해야한다
                        que.append((newPos_r,newPos_c,curTime+1))
        print('current que : {}'.format(que))
    return minTime


def test(tc):
    res = solution(tc)
    print(res)

tcs = [[0, 1, 0, 1], [0, 1, 0, 0], [0, 0, 0, 0], [1, 0, 1, 0]]
test(tcs)