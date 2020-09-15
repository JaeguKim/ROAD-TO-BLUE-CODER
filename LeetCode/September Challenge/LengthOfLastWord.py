class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        ary = s.split(' ')
        for i in range(len(ary)-1,-1,-1):
            if len(ary[i]) > 0:
                return len(ary[i])
        return 0