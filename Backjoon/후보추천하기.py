from collections import defaultdict

class Solution:
    
    def solve(self):
        n = int(input())
        totalRecom = int(input())
        candidateNums = [int(num) for num in input().split()]
        frameInfo = []
        recomDict = defaultdict(int)
        recomTime = defaultdict(int)
        for i in range(totalRecom):
            candidate = candidateNums[i] 
            if recomDict[candidate] == 0:
                recomTime[candidate] = i+1 
                if len(frameInfo) == n:
                    frameInfo = sorted(frameInfo,key=lambda x:(recomDict[x],recomTime[x]))
                    front = frameInfo[0]
                    recomDict[front] = 0
                    frameInfo.pop(0)
                frameInfo.append(candidate)
                recomDict[candidate] = 1
            else:
                recomDict[candidate] += 1
        res = [num for num in sorted(frameInfo)]
        for i,num in enumerate(res):
            if i == len(res)-1:
                print(num)
            else:
                print(num,end=' ')
        
Solution().solve()
        