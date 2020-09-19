from collections import defaultdict
from copy import copy,deepcopy
class Solution:

    def shuffle(self):
        newCardList = [0] * self.N
        for i,val in enumerate(self.S):
            newCardList[val] = self.cardList[i]
        self.cardList = newCardList

    def checkIfSame(self):
        for i in range(self.N):
            if self.P[self.cardList[i]] != i%3:
                return False
        return True

    def simulate(self):
        while not self.checkIfSame():
            self.curMix += 1
            self.shuffle()
            if self.initCard == self.cardList:
                self.curMix = -1
                break
        
    def solve(self):
        self.N = int(input())
        self.P = [int(i) for i in input().split(' ')]
        self.S = [int(i) for i in input().split(' ')]
        self.cardList = [ i for i in range(self.N)]
        self.initCard = self.cardList.copy()
        self.curMix = 0
        self.simulate()
        print(self.curMix)

Solution().solve()