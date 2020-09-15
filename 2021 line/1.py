from collections import defaultdict

def solution(boxes):
    ans = 0
    cntDict = defaultdict(int)
    for box in boxes:
        cntDict[box[0]] += 1
        cntDict[box[1]] += 1
    cnt = 0
    for key in cntDict:
        cnt += cntDict[key]//2
    ans = len(boxes)-cnt
    return ans