from typing import List
class Solution:
    def makeTrie(self,words):
        trie = {}
        trie['root'] = {}
        for word in words:
            cur = trie['root']
            for i in range(len(word)):
                ch = word[i]
                if ch in cur:
                    cur = cur[ch]
                else:
                    cur[ch] = {}
                    cur = cur[ch]
                if i == len(word)-1:
                        cur['$'] = None
        return trie

    def isInBoundary(self,r,c):
        return not(r < 0 or r > len(self.board)-1 or c < 0 or c > len(self.board[0])-1)
    
    def dfs(self,string,r,c,curNode):
        if not self.isInBoundary(r,c) or self.visited[r][c] == 1:
            return
        if self.board[r][c] not in curNode:
            return
        self.visited[r][c] = 1
        string += self.board[r][c]
        childNode = curNode[self.board[r][c]]
        if '$' in childNode:
            self.ans.add(string)
        for i in range(4):
            newR = r+self.dr[i]; newC = c+self.dc[i]
            self.dfs(string,newR,newC,childNode)
        self.visited[r][c] = 0

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        self.board = board
        trie = self.makeTrie(words)
        self.visited = [[0]*len(board[0]) for _ in range(len(board))]
        self.dr = [-1,0,1,0]
        self.dc = [0,1,0,-1]
        print(trie)
        self.ans = set()
        for r in range(len(board)):
            for c in range(len(board[0])):
                self.dfs("",r,c,trie['root'])
        return list(self.ans)

# class TRIE:
#     def __init__(self):
#         self.eow = False
#         self.child = [None]*26
    
#     def update(self,word):
#         cur = self
#         for c in word:
#             idx = ord(c)-ord('a')
#             if cur.child[idx] == None: cur.child[idx] = TRIE()
#             cur = cur.child[idx]
#         cur.eow = True

# class Solution:
#     def isInBoundary(self,r,c):
#         return not(r < 0 or r > len(self.board)-1 or c < 0 or c > len(self.board[0])-1) 
 
#     def dfs(self,s,r,c,trie):
#         if not self.isInBoundary(r,c):
#             return 
#         ch = self.board[r][c]
#         if ch == '!': return
#         self.board[r][c] = '!'
#         t = trie.child[ord(ch)-ord('a')]
#         if t != None:
#             newStr = s+ch
#             if t.eow: self.res.add(newStr)
#             for i in range(4):
#                 newR = r+self.dr[i]; newC = c+self.dc[i]
#                 self.dfs(newStr,newR,newC,t)
#         self.board[r][c] = ch

#     def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
#         if len(words) == 0:
#             return []
#         self.board = board
#         self.dr = [-1,0,1,0]
#         self.dc = [0,1,0,-1]
#         trie = TRIE()
#         for word in words:
#             trie.update(word)
#         self.res = set()
#         for r in range(len(board)):
#             for c in range(len(board[0])):
#                 self.dfs("",r,c,trie)
#         return list(self.res)

def test(tcs):
    sol = Solution()
    for tc in tcs:
        res = sol.findWords(tc[0],tc[1])
        print(res)
tcs = [
    [[
    ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']],
  ["oath","pea","eat","rain"]],
  [[['a']],[]]
]
test(tcs)