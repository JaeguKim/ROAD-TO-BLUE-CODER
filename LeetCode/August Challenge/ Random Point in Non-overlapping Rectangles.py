#python
from random import randint

class Solution:

    def __init__(self, rects: List[List[int]]):
        self.accumSum = []
        self.total = 0
        self.rects = rects
        for rect in rects:
            width = rect[2]-rect[0]+1; height = rect[3]-rect[1]+1
            self.total += width * height
            self.accumSum.append(self.total)
        #print(self.accumSum)

    def pick(self) -> List[int]:
        if len(self.accumSum) == 0:
            return []
        randNum = randint(1,self.total)
        #print(randNum)
        localIdx = 0; w = 0; h = 0;
        for i in range(len(self.accumSum)):
            if randNum <= self.accumSum[i]:
                if i > 0:
                    localIdx = randNum-self.accumSum[i-1]-1
                else:
                    localIdx = randNum-1
                w = self.rects[i][2]-self.rects[i][0]
                x = self.rects[i][0]+localIdx%(w+1); y = self.rects[i][1]+localIdx//(w+1)
                #print('localIdx : {}'.format(localIdx))
                #print('w : {}, x : {}'.format(w,x))
                return [x,y]


# Your Solution object will be instantiated and called as such:
# obj = Solution(rects)
# param_1 = obj.pick()