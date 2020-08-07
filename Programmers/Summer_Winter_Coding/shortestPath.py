from collections import defaultdict
class Solution:
    def bfs(self):
        start = [0,0,1]
        que = []
        self.visited[(0,0)] = 1
        que.append(start)
        while len(que) != 0:
            curPos = que[0]
            #print(curPos)
            curDist = curPos[2]
            que.pop(0)
            for k in range(4):
                newR = curPos[0]+self.dx[k]; newC = curPos[1]+self.dy[k]
                if newR >= 0 and newR < self.M and newC >= 0 and newC < self.N:
                    if newR == self.M-1 and newC == self.N-1:
                        self.ans = min(curDist+1,self.ans) if self.ans != -1 else curDist+1
                        continue
                    if self.visited[(newR,newC)] == 0 and self.maps[newR][newC] == 1:
                        que.append([newR,newC,curDist+1])
                        self.visited[(newR,newC)] = 1

    def solution(self,maps):
        self.M = len(maps); self.N = len(maps[0])
        self.maps = maps
        self.dx = [-1,0,1,0]; self.dy = [0,1,0,-1]
        self.visited = defaultdict(int)
        self.ans = -1
        self.bfs()
        return self.ans


def solution(maps):
    sol = Solution()
    res = sol.solution(maps)
    return res

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = [
    [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]],
    [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]
]

test(tcs)

