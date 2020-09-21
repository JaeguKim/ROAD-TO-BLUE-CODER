from collections import defaultdict

class Solution:
    
    def solve(self):
        n = int(input())
        totalRecom = int(input())
        candidateNums = [int(num) for num in input().split()]
        frameInfo = []
        recomCnt = defaultdict(int)
        recomTime = defaultdict(int)
        for i in range(totalRecom):
            candidate = candidateNums[i] 
            if recomCnt[candidate] == 0:
                recomTime[candidate] = i+1 
                if len(frameInfo) == n: # 프레임이 더이상 공간이 없는경우, 추천수가 낮고 가장 오래된 사진을 제거한다
                    frameInfo = sorted(frameInfo,key=lambda x:(recomCnt[x],recomTime[x])) #추천수와 배치된 시간기준 정렬
                    front = frameInfo[0] #맨앞의 요소를 가저오기
                    recomCnt[front] = 0 #빠져나갈 카운트를 0으로 세팅
                    frameInfo.pop(0) #사진 제거
                frameInfo.append(candidate) #새로운 사진 푸시
                recomCnt[candidate] = 1
            else:
                recomCnt[candidate] += 1
        res = [num for num in sorted(frameInfo)] #후보번호를 대상으로 정렬
        for i,num in enumerate(res):
            if i == len(res)-1:
                print(num)
            else:
                print(num,end=' ')
        
Solution().solve()
        