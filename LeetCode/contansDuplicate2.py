from collections import defaultdict
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        myHash = defaultdict(list)
        
        for i in range(len(nums)):
            num = nums[i]
            if len(myHash[num]) == 0:
                myHash[num].append(i)
            else:
                for idx in myHash[num]:
                    if abs(idx-i) <= k:
                        return True
                myHash[num].append(i)
        return False
        