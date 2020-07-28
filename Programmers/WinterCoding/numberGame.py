def solution(A, B):
    sortedA = sorted(A)
    sortedB = sorted(B)
    n = len(A)
    left = 0; right = 0
    ans = 0
    while (left < n and right < n ):
        if sortedA[left] < sortedB[right]:
            ans+=1
            left+=1
            right+=1
        else:
            right+=1
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1])
        print(res)

tcs = [
    [[5,1,3,7],[2,2,6,8]],
    [[2,2,2,2],[1,1,1,1]],
]
test(tcs)