class Solution:
    def reverseBits(self, n: int) -> int:
        bitSize = 32
        binary = bin(n)
        reverse = binary[-1:1:-1]
        reverse = reverse + (32-len(reverse))*'0'
        return int(reverse,2)

def test(tcs):
    sol = Solution()
    for tc in tcs:
        res = sol.reverseBits(tc)
        print(res)

tcs = [43261596,4294967293]
test(tcs)