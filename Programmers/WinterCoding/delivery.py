from collections import defaultdict
class Solution:
    def bfs(self):
        que = [(1,0,defaultdict(int))]
        while len(que)!=0:
            item = que[0][0]
            accumDist = que[0][1]
            visited = que[0][2]
            que.pop(0)
            for node in self.graph[item]:
                newDist = accumDist+self.dist[item-1][node-1]
                if visited[node] == 0 and newDist <= self.K:
                    if self.dp[node-1] != 0 and self.dp[node-1] < newDist:
                        continue
                    if self.dp[node-1] == 0:
                        self.ans+=1
                    self.dp[node-1] = newDist
                    newVisited = visited.copy()
                    newVisited[node] = 1
                    que.append((node,newDist,newVisited))

    def solution(self,N, road, K):
        self.graph = defaultdict(list)
        self.dist = []
        self.K = K
        self.dp = [0]*N
        self.dp[0] = -1
        self.ans = 1
        for i in range(N):
            lst = [0]*N
            self.dist.append(lst)
        
        for s,e,d in road:
            if self.dist[s-1][e-1] == 0 or self.dist[s-1][e-1] > d:
                if e not in self.graph[s]:
                    self.graph[s].append(e); self.graph[e].append(s)
                self.dist[s-1][e-1] = d; self.dist[e-1][s-1] = d
        self.bfs()
        return self.ans


def solution(N, road, K):
    answer = Solution().solution(N,road,K)
    return answer

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1],tc[2])
        print(res)

tcs = [[5,[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]],3],
        [6,[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]],4],
        ]
test(tcs)