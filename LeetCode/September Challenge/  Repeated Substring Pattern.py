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
