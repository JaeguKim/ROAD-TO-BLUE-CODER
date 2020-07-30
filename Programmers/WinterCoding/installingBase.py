#사고력이 필요한문제
def solution(n, stations, w):
    answer = 0
    idx = 0
    location = 1
    while location<=n:
        if idx < len(stations) and location >= stations[idx]-w:
            location = stations[idx]+w+1
            idx+=1
        else:
            answer+=1
            location+=2*w+1
    return answer

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1],tc[2])
        print(res)

tcs = [
    [11,[4, 11],1],
    [16,[9],2],
]
test(tcs)