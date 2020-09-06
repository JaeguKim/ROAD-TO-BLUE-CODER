from collections import defaultdict
class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:

        N = len(s)
        if N <= 1:
            return False
        
        for i in range(1,(N//2)+1):
            if N % i == 0:
                if s[:i] * (N//i) == s:
                    return True
        return False

#SOL 2 USING KMP
from collections import defaultdict
class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        N = len(s)
        lps = [0]*N

        for i in range(1,N):
            j = lps[i-1]
            while j > 0 and s[i] != s[j]: j = lps[j-1]
            if s[i] == s[j]: j+=1
            lps[i] = j
        if lps[-1] == 0:
            return False
        else:
            if N % (N-lps[-1]) == 0:
                return True
            else:
                return False