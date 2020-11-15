from collections import defaultdict,deque

class Solution:

    def bfs(self,start):
        que = deque()
        visited = defaultdict(int)
        que.append((start,0))
        maxNode = (0,-1)
        visited[start] = 1
        while len(que) > 0:
            front = que.popleft()
            self.count[front[1]] += 1
            if (front[1] > maxNode[1]):
                maxNode = front
            for next in self.adjList[front[0]]:
                if visited[next] == 0:
                    visited[next] = 1
                    que.append((next,front[1]+1))
        return maxNode
                    
    def solve(self,n,edges):
        self.n = n
        self.edges = edges
        self.adjList = defaultdict(list)
        for edge in edges:
            self.adjList[edge[0]].append(edge[1])
            self.adjList[edge[1]].append(edge[0])
        self.count = defaultdict(int)
        maxNode,maxLen = self.bfs(1)
        self.count = defaultdict(int)
        maxNode,maxLen = self.bfs(maxNode)
        if (self.count[maxLen] >= 2):
            return maxLen
        self.count = defaultdict(int)
        maxNode,maxLen = self.bfs(maxNode)
        if (self.count[maxLen] >= 2):
            return maxLen
        return maxLen-1
        
def solution(n, edges):
    return Solution().solve(n,edges)