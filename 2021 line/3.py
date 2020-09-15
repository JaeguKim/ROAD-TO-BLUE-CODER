class Solution:

    def helper(self,num,sliceCnt):
        if num >= 0 and num <= 9:
            if len(self.ans) == 0:
                self.ans = [sliceCnt,num]
            else:
                if sliceCnt < self.ans[0]:
                    self.ans = [sliceCnt,num]
            return
        numStr = str(num)
        for i in range(1,len(numStr)):
            frontStr = numStr[:i]
            rearStr = numStr[i:]
            if rearStr[0] == '0':
                continue
            frontNum = int(frontStr)
            rearNum = int(rearStr)
            self.helper(frontNum+rearNum,sliceCnt+1)

    def solve(self,n):
        self.ans = []
        self.helper(n,0)
        return self.ans


def solution(n):
    sol = Solution()
    return sol.solve(n)