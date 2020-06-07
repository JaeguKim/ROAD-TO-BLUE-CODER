#1hour 9min 24sec
#잘못된 풀이를 떠올린경우, Cracking The Coding Interview에서 비슷한 문제, 최적화를 한번더 시켜야하는 문제
#randRange에서 end boundary는 랜덤수 생성에 포함되지 않는다
from random import randrange
class Solution:

    def __init__(self, w: List[int]):
        self.w = w
        sum = 0
        self.accumSum = [0]
        for i in range(len(w)):
            sum+=self.w[i]
            self.accumSum.append(sum)
        
    def pickIndex(self) -> int:
        randNum = random.random()
        exp = randNum * self.accumSum[-1]
        left = 0; right = len(self.accumSum)-1
        res = 0
        while left<=right:
            mid = int((left+right)/2)
            if mid+1 >= len(self.accumSum):
                res = mid
                break
            if exp >= self.accumSum[mid] and exp < self.accumSum[mid+1]:
                res = mid
                break
            elif exp < self.accumSum[mid]:
                right = mid
            elif exp >= self.accumSum[mid+1]:
                left = mid+1
        return res
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()