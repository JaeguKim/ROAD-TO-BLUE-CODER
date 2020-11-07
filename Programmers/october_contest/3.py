from collections import defaultdict,deque
# root node일단 하나 BFS 해서 제일 긴거리 구하기 그리고 결과 -1

class Solution:

    def bfs(self,start):
        que = deque()
        visited = defaultdict(int)
        que.append((start,0))
        maxNode = (0,-1)
        visited[start] = 1
        while len(que) > 0:
            front = que.popleft()
            #print(front)
            self.count[front[1]] += 1
            if (front[1] > maxNode[1]):
                maxNode = front
            for next in self.adjList[front[0]]:
                if visited[next] == 0:
                    visited[next] = 1
                    que.append((next,front[1]+1))
        return maxNode
                    
    def findMax(self,maxVal,candidate):
        cnt = 2
        remainingCnt = self.totalCnt
        for i in range(maxVal,0,-1):
            remainingCnt -= self.count[i]
            if cnt < self.count[i] or (cnt == self.count[i] and remainingCnt > 0):
                return max(candidate,i)
            cnt -= self.count[i]
            
        return candidate
    
    def getTotalCnt(self,maxVal):
        sumVal = 0
        for i in range(maxVal,0,-1):
            sumVal += self.count[i]
        return sumVal
    
    def findRoot(self):
        hash = defaultdict(int)
        for edge in self.edges:
            hash[edge[1]] = 1
        for i in range(1,self.n+1):
            if hash[i] == 0:
                return i
    
    def solve(self,n,edges):
        self.n = n
        self.edges = edges
        self.root = self.findRoot()
        self.adjList = defaultdict(list)
        for edge in edges:
            self.adjList[edge[0]].append(edge[1])
            self.adjList[edge[1]].append(edge[0])
        #print(self.adjList)
        self.count = defaultdict(int)
        maxNode = self.bfs(1)
        self.count = defaultdict(int)
        #print(maxNode[0])
        maxLen = self.bfs(maxNode[0])[1]
        print(self.count)
        #self.totalCnt = self.getTotalCnt(maxLen)
        #res = self.findMax(maxLen,maxLen-1)
        
        if (self.count[maxLen] > 2):
            return maxLen
        elif (self.count[maxLen]+self.count[maxLen-1] > 2):
            return maxLen-1
        else: return maxLen-1
        
def solution(n, edges):
    return Solution().solve(n,edges)

test = []
n = 4	
edges = [[1,2],[2,3],[3,4]]
n = 5	
edges = [[1,5],[2,5],[3,5],[4,5]]
# n = 3
# edges = [[1,2],[2,3],[3,1]]
res = solution(n,edges)
print(res)

'''
from collections import defaultdict,deque
# root node일단 하나 BFS 해서 제일 긴거리 구하기 그리고 결과 -1

class Solution:

    def bfs(self,start):
        que = deque()
        visited = defaultdict(int)
        que.append((start,0))
        maxNode = (0,-1)
        visited[start] = 1
        while len(que) > 0:
            front = que.popleft()
            #print(front)
            self.count[front[1]] += 1
            if (front[1] > maxNode[1]):
                maxNode = front
            for next in self.adjList[front[0]]:
                if visited[next] == 0:
                    visited[next] = 1
                    que.append((next,front[1]+1))
        return maxNode

    def findMax(self,maxVal,candidate):
        cnt = 2
        remainingCnt = self.totalCnt
        for i in range(maxVal,0,-1):
            remainingCnt -= self.count[i]
            if cnt <= self.count[i] and remainingCnt > 0:
                return max(candidate,i)
            cnt -= self.count[i]

        return candidate

    def getTotalCnt(self,maxVal):
        sumVal = 0
        for i in range(maxVal,0,-1):
            sumVal += self.count[i]
        return sumVal

    def findRoot(self):
        hash = defaultdict(int)
        for edge in self.edges:
            hash[edge[1]] = 1
        for i in range(1,self.n+1):
            if hash[i] == 0:
                return i

    def solve(self,n,edges):
        self.n = n
        self.edges = edges
        self.root = self.findRoot()
        self.adjList = defaultdict(list)
        for edge in edges:
            self.adjList[edge[0]].append(edge[1])
            self.adjList[edge[1]].append(edge[0])
        #print(self.adjList)
        self.count = defaultdict(int)
        maxNode = self.bfs(1)
        self.count = defaultdict(int)
        #print(maxNode[0])
        maxLen = self.bfs(maxNode[0])[1]
        #print(self.count)
        self.totalCnt = self.getTotalCnt(maxLen)
        res = self.findMax(maxLen,maxLen-1)
        return res

def solution(n, edges):
    return Solution().solve(n,edges)

'''