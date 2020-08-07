from collections import defaultdict

def solution(nums):
    N = len(nums)
    myHash = defaultdict(int)
    for num in nums:
        myHash[num] = 1
    ans = 0
    if len(myHash) <= N//2:
        ans = len(myHash)
    else:
        ans = N//2
    return ans

    