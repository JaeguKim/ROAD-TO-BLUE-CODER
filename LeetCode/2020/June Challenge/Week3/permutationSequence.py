from itertools import permutations
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        l = list(permutations(range(1,n+1)))
        res = l[k-1]
        ans = ''
        for el in res:
            ans+=str(el)
        return ans

def test(testCases):
    sol = Solution()
    for tc in testCases:
        res = sol.getPermutation(tc[0],tc[1])
        print(res)

testCases = [[3,3],[4,9]]
test(testCases)