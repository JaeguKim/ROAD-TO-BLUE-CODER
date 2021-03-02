class Solution:
    def isPowerOfFour(self, num: int) -> bool:
        if num <= 0:
            return False
        cur = num
        while cur != 1:
            if cur%4 == 0:
                cur = cur//4
            else:
                return False
        return True