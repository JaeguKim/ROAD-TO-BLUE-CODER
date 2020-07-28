import collections
import sys
sys.setrecursionlimit(10**6)
def makeDirectedGraph(n,indirectedGraph,directedGraph,parent,node):
    for neighbor in indirectedGraph[node]:
        if neighbor != parent:
            directedGraph[neighbor].append(node)
            makeDirectedGraph(n,indirectedGraph,directedGraph,node,neighbor)

def isCyclicUtil(graph,v,visited, recStack): 
    visited[v] = True
    recStack[v] = True

    for neighbour in graph[v]: 
        if visited[neighbour] == False: 
            if isCyclicUtil(graph,neighbour,visited,recStack) == True: 
                return True
        elif recStack[neighbour] == True: 
            return True

    recStack[v] = False
    return False

# Returns true if graph is cyclic else false 
def isCyclic(n,graph): 
    visited = [False] * n 
    recStack = [False] * n 
    for node in range(n): 
        if visited[node] == False: 
            if isCyclicUtil(graph,node,visited,recStack) == True: 
                return True
    return False
    
def solution(n, path, order):
    indirectedGraph = collections.defaultdict(list)
    directedGraph = collections.defaultdict(list)
    for s,e in path:
        indirectedGraph[s].append(e)
        indirectedGraph[e].append(s)
    makeDirectedGraph(n,indirectedGraph,directedGraph,-1,0)
    for first,second in order:
        directedGraph[second].append(first)
    
    return isCyclic(n,directedGraph) == False

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1],tc[2])
        print(res)

tcs = [
    [9,[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]],[[8,5],[6,7],[4,1]]],
    [9,[[8,1],[0,1],[1,2],[0,7],[4,7],[0,3],[7,5],[3,6]],[[4,1],[5,2]]],
    [9,[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]],[[4,1],[8,7],[6,5]]],
]

test(tcs)