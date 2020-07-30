def solution(sticker):
    if len(sticker) == 1:
        return sticker[0]
    N = len(sticker)
    dp1 = [0]*N
    dp1[0] = sticker[0]; dp1[1] = sticker[0]
    for i in range(2,N-1):
        dp1[i] = max(dp1[i-2]+sticker[i],dp1[i-1])
    dp2 = [0]*N
    dp2[0] = 0; dp2[1] = sticker[1]
    for i in range(2,N):
        dp2[i] = max(dp2[i-2]+sticker[i],dp2[i-1])
    ans = max(max(dp1),max(dp2))
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = [[14, 6, 5, 11, 3, 9, 2, 10],[1, 3, 2, 5, 4],[2]]
test(tcs)