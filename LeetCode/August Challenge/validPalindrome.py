class Solution:
    def isPalindrome(self, s: str) -> bool:
        newList = []
        for ch in s:
            if ch.isalpha() or ch.isdigit():
                newList.append(ch)
        reversedStr = newList[::-1]
        return newList == reversedStr