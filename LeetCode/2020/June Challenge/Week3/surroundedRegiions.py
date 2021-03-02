#38min
from typing import List
import sys

sys.setrecursionlimit(10**6)
class Solution:
    def __init__(self):
        self.rOffset = [-1,0,1,0]
        self.cOffset = [0,1,0,-1]

    def dfs(self,board,table,r,c,rowLen,colLen):
        table[r][c] = True
        for i in range(4):
            newR = r+self.rOffset[i]; newC = c+self.cOffset[i]
            if newR<=0 or newR>=rowLen-1 or newC<=0 or newC>=colLen-1:
                continue
            if board[newR][newC] == 'O' and table[newR][newC] == False:
                self.dfs(board,table,newR,newC,rowLen,colLen)

    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rowLen = 0; colLen = 0
        if len(board) != 0:
            rowLen = len(board); colLen = len(board[0])
        table = [[False]*colLen for _ in range(rowLen)]
        for r in range(rowLen):
            for c in range(colLen):
                if board[r][c] == 'O' and (r==0 or r==rowLen-1 or c==0 or c==colLen-1):
                    self.dfs(board,table,r,c,rowLen,colLen)
        
        for r in range(rowLen):
            for c in range(colLen):
                if board[r][c] == 'O' and table[r][c] == False:
                    board[r][c] = 'X'
def test():
    sol = Solution()
    sol.solve([["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]])
    sol.solve([["O","O","O","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]])
    sol.solve([["X","O","X","X"],["X","O","O","X"],["X","X","O","X"],["X","X","X","X"]])
    sol.solve([["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","X","X","X"]])
    sol.solve([["O","O","O","O"],["O","O","O","O"],["O","O","O","O"],["O","O","O","O"]])
    sol.solve([])
    
    
    

test()
        