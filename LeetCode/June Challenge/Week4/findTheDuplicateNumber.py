class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        n = len(nums)
        hash = [0]*(n+1)
        for num in nums:
            if hash[num] == 1:
                return num
            else:
                hash[num]+=1
        