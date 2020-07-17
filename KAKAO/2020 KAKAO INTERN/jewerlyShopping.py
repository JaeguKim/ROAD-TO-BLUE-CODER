#TIME : 2hour
def solution(gems):
    items = set()
    for gem in gems:
        items.add(gem)
    left = 0; right = 1;
    cntDict = {}
    cntDict[gems[0]] = 1
    ans = [0,0]
    ansLen = len(gems)
    while (left <= right):
        #print('left:{}, right:{}'.format(left,right))
        #print(basket)
        if len(cntDict) == len(items):
            interval = right - left - 1
            if ansLen > interval:
                ans = [left+1,right]
                #print(ans)
                ansLen = interval
            leftItem = gems[left]
            cntDict[leftItem] -= 1
            if cntDict[leftItem] == 0:
                cntDict.pop(leftItem)
            left+=1
        else:
            if right > len(gems)-1:
                break
            rightItem = gems[right]
            if rightItem in cntDict:
                cntDict[rightItem]+=1
            else:
                cntDict[rightItem]=1
            right+=1
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = [
    ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"],
    ["AA", "AB", "AC", "AA", "AC"],
    ["XYZ", "XYZ", "XYZ"],
    ["ZZZ", "YYY", "NNNN", "YYY", "BBB"],
        ["A"],
    ]
test(tcs)