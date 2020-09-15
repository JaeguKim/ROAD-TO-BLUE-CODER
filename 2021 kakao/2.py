from collections import defaultdict
from itertools import combinations

def solution(orders, course):
    ordersDict = defaultdict(int) #조합 각각의 갯수
    ordersForLenDict = defaultdict(list) #길이에 따른 조합들
    maxOrdersForLenDict = defaultdict(int) #길이에 따른 조합의 최대 주문수

    for length in course:
        for order in orders:
            for comb in combinations(order,length):
                combStr = ''.join(sorted(comb))
                #combStr = ''.join(sorted(combStr))
                #print(combStr)
                if combStr not in ordersForLenDict[length]:
                    ordersForLenDict[length].append(combStr)
                ordersDict[combStr] += 1
                combCnt = ordersDict[combStr]
                maxOrdersForLenDict[length] = max(maxOrdersForLenDict[length],combCnt)

    print(ordersDict)
    print(ordersForLenDict)
    print(maxOrdersForLenDict)
    ans = []
    for length in course:
        maxOrderCnt = maxOrdersForLenDict[length]
        if maxOrderCnt < 2:
            continue
        for comb in ordersForLenDict[length]:
            if maxOrderCnt == ordersDict[comb]:
                ans.append(comb)
    ans = sorted(ans)
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1])
        print(res)
tcs = [
        #[["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"],[2,3,4]],
        #[["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]],
        [["XYZ", "XWY", "WXA"], [2, 3, 4]],
        ]
test(tcs)