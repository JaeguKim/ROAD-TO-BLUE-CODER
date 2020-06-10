class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        # if target <= nums[i] : return i, else: if i+=1 ; if i >= len(nums): return len(nums)-1
        i = 0
        while True:
            if target <= nums[i]:
                return i
            else:
                i+=1
                if i >= len(nums):
                    return len(nums)