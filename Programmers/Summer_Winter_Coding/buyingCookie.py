#뭔가 새로운 알고리즘을 알아야 최적화 시킬수 있다고 생각했지만, 실제로는 단순한 몇가지 아이디어로 최적화가 가능한 문제.
class Solution:
    def findSplitPoint(self,arr, n) : 
        ans = 0
        total = sum(arr)
        for left in range(0,n-1):
            leftSum = 0
            for i in range(left, n-1) :
                leftSum += arr[i]
                if leftSum > total//2:
                    break
                if leftSum < ans:
                    continue
                rightSum = 0 
                for j in range(i+1, n) : 
                    rightSum += arr[j]  
                    if leftSum == rightSum: 
                        ans = max(leftSum,ans)
                    if leftSum <= rightSum:
                        break
        return ans

def solution(cookie):
    sol = Solution()
    n = len(cookie)
    ans = sol.findSplitPoint(cookie,n)
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = [[1,1,2,3],[1,2,4,5]]
test(tcs)