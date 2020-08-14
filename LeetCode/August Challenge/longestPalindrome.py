from collections import defaultdict
class Solution:
    def longestPalindrome(self, s: str) -> int:
        N = len(s)
        _dict = defaultdict(int)
        for ch in s:
            _dict[ch]+=1
        odd = 0
        res = 0
        for key in _dict:
            if _dict[key] %2 == 0:
                res+=_dict[key]
            else:
                if odd == 0:
                    odd+=1; res+=1
                else:
                    return res
        return res