#11min 39sec
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        leftS = 0; leftT = 0
        while leftT < len(t) and leftS < len(s):
            if s[leftS] == t[leftT]:
                leftS +=1; leftT +=1
            else:
                leftT+=1
        return leftS >= len(s)