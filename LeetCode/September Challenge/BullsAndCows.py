from collections import defaultdict

class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        cntDict = defaultdict(int)
        cntA=0;cntB=0
        for ch in secret:
            cntDict[ch] += 1
        for i,ch in enumerate(guess):
            if cntDict[ch] != 0 and ch == secret[i]:
                cntA += 1
                cntDict[ch] -= 1
        
        for i,ch in enumerate(guess):
            if cntDict[ch] != 0 and ch != secret[i]:
                cntB += 1
                cntDict[ch] -= 1
        
        res = ''
        res += '{}A'.format(cntA)
        res += '{}B'.format(cntB)
        return res
            