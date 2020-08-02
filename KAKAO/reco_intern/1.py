from collections import defaultdict

def countDuplicate(numbers):
    countDict = defaultdict(int)
    for number in numbers:
        countDict[number]+=1
    ans = 0
    for key in countDict:
        if countDict[key] > 1:
            ans+=1
    return ans

def test(tcs):
    for tc in tcs:
        res = countDuplicate(tc)
        print(res)

tcs = [[1,3,3,4,4,4]]
test(tcs)