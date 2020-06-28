#python integer type is not 32bit so result value is interpretted different with c++ default int type.
from typing import List
# 13min
class Solution:
    # def singleNumber(self, nums: List[int]) -> int:
    #     sortednums = sorted(nums)
    #     i = 0
    #     while i < len(nums):
    #         if i+1 < len(sortednums) and i+2 < len(sortednums) and sortednums[i] == sortednums[i+1] == sortednums[i+2]:
    #             i+=3
    #         else:
    #             return sortednums[i]
    #     return 0
    
    def singleNumber(self, nums: List[int]) -> int:
        f = [0]*32
        for num in nums:
            for i in range(32):
                if num & (1<<i):
                    f[i]+=1
        print(f)
        res = 0
        for i in range(len(f)):
            if f[i]%3 == 1:
                res += 1<<i
        return res if res < (1<<31) else res - (1<<32)

def test(testCases):
    sol = Solution()
    for tc in testCases:
        print(sol.singleNumber(tc))

testCases = [ [2,2,3,2] , [0,1,0,1,0,1,99],[-2,-2,1,1,-3,1,-3,-3,-4,-2]]
test(testCases)    

                
                
                