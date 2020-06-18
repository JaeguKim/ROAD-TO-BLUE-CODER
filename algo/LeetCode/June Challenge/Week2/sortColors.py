class Solution:
    def sortColors(self, nums: List[int]) -> None:
        cnt = {0:0,1:0,2:0}
        for num in nums:
            cnt[num]+=1
        idx = 0
        for key in cnt.keys():
            for i in range(cnt[key]):
                nums[idx]=key
                idx+=1

        