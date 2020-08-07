import math

def solution(w,h):
    return w*h-(w+h-math.gcd(w,h))

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1])
        print(res)

tcs = [[8,12],[1,1],[5,5],[1,5],[5,1]]
test(tcs)