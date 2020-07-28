from typing import List
import collections

class Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        self.graph = {}
        graph = collections.defaultdict(list)
        for s,e in edges:
            graph[s].append(e)
            graph[e].append(s)
        ans = [0]*n
        def recur(cur,parent):
            count = collections.Counter()
            for node in graph[cur]:
                if node != parent:
                    count += recur(node,cur)
            count[labels[cur]] += 1
            ans[cur] = count[labels[cur]]
            return count
        recur(0,-1)
        return ans

def test(tcs):
    sol = Solution()
    for tc in tcs:
        res = sol.countSubTrees(tc[0],tc[1],tc[2])
        print(res)

tcs =[ [7,[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],"abaedcd"],
        [4,[[0,2],[0,3],[1,2]],"aeed"]
    ]
test(tcs)