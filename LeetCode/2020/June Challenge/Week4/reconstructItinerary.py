from typing import List
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        graph = {}
        tickets.sort(key=lambda x:x[1])
        for ticket in tickets:
            if ticket[0] not in graph: graph[ticket[0]] = [ticket[1]]
            else: graph[ticket[0]].append(ticket[1])
        my_stack = []
        ans = []
        my_stack.append('JFK')
        while len(my_stack)!=0:
            src = my_stack[-1]
            if src not in graph or len(graph[src]) == 0:
                ans.append(src)
                my_stack.pop()
            else:
                dst = graph[src][0]
                my_stack.append(dst)
                graph[src] = graph[src][1:]
        return ans[::-1]



        self.res = []
        self.dfs('JFK')
        return self.res[::-1]

def test(tcs):
    sol = Solution()
    for tc in tcs:
        print(sol.findItinerary(tc))

tcs = [
[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]],
[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]],
[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
]
test(tcs)