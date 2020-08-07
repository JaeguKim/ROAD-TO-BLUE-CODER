def isPrime(num):
    for i in range(2,num):
        if num%i == 0:
            return False
    return True

def solution(nums):
    N=len(nums)
    ans = 0
    for i in range(N):
        for j in range(i+1,N):
            for k in range(j+1,N):
                summation = nums[i]+nums[j]+nums[k]
                if isPrime(summation):
                    ans+=1
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = [
    [1,2,3,4],
    [1,2,7,6,4],
]
test(tcs)