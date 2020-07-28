def solution(d, budget):
    answer = 0
    sortedD = sorted(d)
    sum = 0
    for item in sortedD:
        sum += item
        if sum > budget:
            break
        answer += 1
    return answer

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1])
        print(res)

tcs = [[[1,3,2,5,4],9],[[2,2,3,3],10]]
test(tcs)