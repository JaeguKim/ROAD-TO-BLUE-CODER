class Solution:
    
    def isPos(self,num):
        for ch in self.malfuncBtn:
            if ch in str(num):
                return False
        return True
    
    # def findFirstDeadBtn(self,num):
    #     deadBtnIdx = -1
    #     n = len(str(num))
    #     for ch in self.malfuncBtn:
    #         if ch in str(num):
    #             curIdx = n-1-str(num).index(ch)
    #             if deadBtnIdx == -1:
    #                 deadBtnIdx = curIdx
    #             else:
    #                 deadBtnIdx = min(deadBtnIdx,curIdx)
                
    #     return deadBtnIdx
    
    def solve(self):
        n = int(input())
        malfuncCnt = int(input())
        self.malfuncBtn = []
        if malfuncCnt > 0:
            self.malfuncBtn = [i for i in input().split()]
        if malfuncCnt == 10:
            print(abs(n-100))
            return
        case1 = n
        bestCase = abs(n-100)
        while True:
            if self.isPos(case1):
                bestCase = min(bestCase,len(str(case1))+abs(n-case1))
                break
            if len(str(case1))+abs(n-case1) > bestCase:
                break
            case1+=1
        case2 = n-1
        while True:
            if self.isPos(case2):
                bestCase = min(bestCase,len(str(case2))+abs(n-case2))
                break
            if len(str(case2))+abs(n-case2) > bestCase:
                break
            case2 -=1
        print(bestCase)
        
Solution().solve()