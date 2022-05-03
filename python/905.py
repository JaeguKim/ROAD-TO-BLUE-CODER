from typing import List

class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        left = 0
        right = len(nums)-1
        while left < right:
            if nums[left] % 2 == 1 and nums[right] % 2 == 0:
                tmp = nums[left]
                nums[left] = nums[right]
                nums[right] = tmp
            if nums[left] % 2 == 0:
                left += 1
            if nums[right] % 2 == 1:
                right -= 1
        return nums

if __name__ == '__main__':
    print(Solution().sortArrayByParity([3,1,2,4]))
    print(Solution().sortArrayByParity([0]))

