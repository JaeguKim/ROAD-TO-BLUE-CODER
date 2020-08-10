class Solution:
    def titleToNumber(self, s: str) -> int:
        reversedS = s[::-1]
        ans = 0
        for i in range(len(s)):
            ans+=pow(26,i)*(ord(reversedS[i])-ord('A')+1)
        return ans