from collections import defaultdict
def prison(n, m, h, v):
    horizontalDict = defaultdict(list)
    verticalDict = defaultdict(list)
    for i in range(0,n+1):
        horizontalDict[i].append(i-1)
        horizontalDict[i].append(i+1)
    for i in range(0,m+1):
        verticalDict[i].append(i-1)
        verticalDict[i].append(i+1)
    #print(horizontalDict)
    #print(verticalDict)
    maxWidth = 1
    for val in h:
      #  print(val)
        prevIdx = horizontalDict[val][0]
        nextIdx = horizontalDict[val][1]
        horizontalDict[prevIdx][1] = nextIdx
        if val != n:
            horizontalDict[nextIdx][0] = prevIdx
        maxWidth = max(maxWidth,nextIdx-prevIdx)
    #print(horizontalDict)
    maxHeight = 1
    for val in v:
       # print(val)
        prevIdx = verticalDict[val][0]
        nextIdx = verticalDict[val][1]
        verticalDict[prevIdx][1] = nextIdx
        if val != m:
            verticalDict[nextIdx][0] = prevIdx
        maxHeight = max(maxHeight,nextIdx-prevIdx)
    #print(verticalDict)
    return maxWidth*maxHeight

def test(tcs):
    for tc in tcs:
        res = prison(tc[0],tc[1],tc[2],tc[3])
        print(res)

tcs = [[2,2,[1],[2]],
[3,2,[1,2,3],[1,2]],
[3,3,[2],[2]],
[1,1,[1],[1]],
]
test(tcs)