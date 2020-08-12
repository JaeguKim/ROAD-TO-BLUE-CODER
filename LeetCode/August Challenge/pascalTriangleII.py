class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        N = 0
        for i in range(1,rowIndex+2):
            N += i
        ary = [1]*N
        idx = 0
        for r in range(1,rowIndex+2):
            for c in range(r):
                if c != 0 and c != i-1:
                    lastRow = idx-j-(i-1)
                    leftUpper = lastRow + j-1
                    rightUpper = lastRow + j
                    ary[idx] = ary[leftUpper] + ary[rightUpper]
                idx+=1
        ans = ary[N-rowIndex-1:]
        return ans