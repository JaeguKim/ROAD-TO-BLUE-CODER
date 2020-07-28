class Solution:
    def minFlips(self, target: str) -> int:
        prev = '0'; cnt = 0
        for num in target:
            if prev != num:
                #print('{} to {}'.format(prev,num))
                #print(cnt)
                prev = num
                cnt+=1
        return cnt

def test(tcs):
    sol = Solution()
    for tc in tcs:
        res = sol.minFlips(tc)
        print(res)
tcs = ["001011101"]
test(tcs)