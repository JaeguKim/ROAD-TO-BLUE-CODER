from collections import defaultdict,deque
from copy import deepcopy

class Solution:
    
    def checkBound(self,r,c):
        if r < 0 or r > self.n-1 or c < 0 or c > self.n-1:
            return False
        return True
    
    def checkMove(self,pos1,pos2):
        p1 = self.map[pos1[0]][pos1[1]]
        p2 = self.map[pos2[0]][pos2[1]]
        diff = abs(p1-p2)
        if diff >= self.l and diff <= self.r:
            return True
        else:
            return False

    def bfs(self,start):
        traversed = defaultdict(int)
        summ = 0
        que = deque()
        que.append(start)
        isAdded = defaultdict(int)
        self.visited[start] = 1
        while len(que) > 0:
            front = que[0]
            traversed[front] = 1
            if isAdded[front] == 0:
                summ += self.map[front[0]][front[1]]
                isAdded[front] = 1
            que.popleft()
            for i in range(4):
                nextPos = (front[0]+self.offset[i][0],front[1]+self.offset[i][1])
                if self.checkBound(nextPos[0],nextPos[1]) and self.visited[nextPos] == 0 and self.checkMove(front,nextPos):
                    que.append(nextPos)
                    self.visited[nextPos] = 1
                    
        for node in traversed:
            self.newMap[node[0]][node[1]] = summ//len(traversed)
        return len(traversed) > 1
        
    def solve(self):
        self.n,self.l,self.r = [int(i) for i in input().split()]
        self.map = []
        for _ in range(self.n):
            line = [int(j) for j in input().split()]
            self.map.append(line)
        self.offset = [(0,1),(0,-1),(1,0),(-1,0)]
        res = 0
        
        while True:
            self.visited = defaultdict(int)
            flag = True
            self.newMap = deepcopy(self.map)
            for i in range(self.n):
                for j in range(self.n):
                    if self.visited[(i,j)] == 0 and self.bfs((i,j)):
                        flag = False
            if flag:
                break
            self.map = self.newMap
            res += 1
        print(res)
Solution().solve()