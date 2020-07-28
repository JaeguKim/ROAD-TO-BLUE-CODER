class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        n = len(s)
        ary = [0]*n
        for i in range(len(s)):
            ary[indices[i]] = s[i]
        return ''.join(ary)