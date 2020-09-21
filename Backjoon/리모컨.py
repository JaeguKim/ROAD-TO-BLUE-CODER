class Solution:
    
    #리모컨으로 누를수 있는지 반환
    def isPos(self,num):
        for ch in self.malfuncBtn:
            if ch in str(num):
                return False
        return True

    def solve(self):
        n = int(input())
        malfuncCnt = int(input())
        self.malfuncBtn = []
        if malfuncCnt > 0: #실수하기 쉬운부분, 0이면 다음 인풋이 들어오지 않는다
            self.malfuncBtn = [i for i in input().split()]
        if malfuncCnt == 10: #10개의 숫자버튼이 모두 고장
            print(abs(n-100)) #그냥 계산
            return
        bestCase = abs(n-100) #위,아래 버튼으로만 누를때
        case1 = n
        #목표숫자보다 크거나 같은수중 누를수있는 가장 가까운 구하기
        while True:
            if self.isPos(case1):
                bestCase = min(bestCase,len(str(case1))+abs(n-case1))
                break
            if len(str(case1))+abs(n-case1) > bestCase: # 이때 지난경우보다 누르는횟수가 증가하면 종료
                break
            case1+=1
        case2 = n-1
        #목표숫자보다 작은수중 누를수있는 가장 가까운 수 구하기
        while True:
            if self.isPos(case2):
                bestCase = min(bestCase,len(str(case2))+abs(n-case2))
                break
            if len(str(case2))+abs(n-case2) > bestCase: # 이때 지난경우보다 누르는 횟수가 증가하면 종료
                break
            case2 -=1
        print(bestCase)
        
Solution().solve()