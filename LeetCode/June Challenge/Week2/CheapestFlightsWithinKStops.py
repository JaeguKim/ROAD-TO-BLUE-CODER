#33min
from typing import List
import sys
class Solution:
    def dfs(self,adjList:List[List[int]],visited:List[List[int]],price: List[List[int]],src:int,dst:int,k:int,curCost:int,minVal:List) -> int:
        if k<-1:
            return
        if src == dst:
            minVal[0] = min(curCost,minVal[0])
            return
        for node in adjList[src]:
            if visited[src][node] == False:
                curCost+=price[src][node]
                if curCost < minVal[0]:
                    self.dfs(adjList,visited,price,node,dst,k-1,curCost,minVal)
                curCost-=price[src][node]

    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        price : List[List[int]] = [[0]*n for _ in range(n)]
        adjList : List[List[int]] = [[]*n for _ in range(n)]
        visited : List[List[int]] = [[False]*n for _ in range(n)]
        for path in flights:
            price[path[0]][path[1]] = path[2]
            adjList[path[0]].append(path[1])
        res = [float('inf')]
        self.dfs(adjList,visited,price,src,dst,K,0,res)
        return res[0] if res[0] != float('inf') else -1

sol = Solution()
res = sol.findCheapestPrice(3,[[0,1,100],[1,2,100],[0,2,500]],0,2,1)
#res = sol.findCheapestPrice(3,[[0,1,100],[1,2,100],[0,2,500]],0,2,0)
#res = sol.findCheapestPrice(5,[[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]],2,1,1)
print(res)