from collections import defaultdict

def isCoordShared(pos1,pos2):
    if pos1[0] == pos2[0] or pos1[1] == pos2[1]:
        return True
    else:
        return False

def getDict(pos1,pos2):
    return abs(pos1[0]-pos2[0]) + abs(pos2[1]-pos2[1])

def closestStraightCity(c, x, y, q):
    cityInfo = defaultdict(list)
    distInfo = defaultdict(int)
    N = len(c)
    ans = []
    for i in range(N):
        cityInfo[c[i]].append(x[i])
        cityInfo[c[i]].append(y[i])
    for query in q:
        selections = {}
        for cityName in cityInfo:
            if cityName != query and distInfo[(query,cityName)] != -1:
                p1 = cityInfo[query]
                p2 = cityInfo[cityName]
                if isCoordShared(p1,p2):
                    if distInfo[(query,cityName)] == 0:
                        dist = getDict(p1,p2)
                        distInfo[(query,cityName)] = dist
                        distInfo[(cityName,query)] = dist
                    else:
                        dist = distInfo[(query,cityName)]
                    selections[cityName] = dist
                else:
                    distInfo[(query,cityName)] = -1
                    distInfo[(cityName,query)] = -1
        if len(selections) == 0:
            ans.append('NONE')
        else:
            sortedSelections = sorted(selections.items(),key=lambda x:(x[1],x[0]))
            ans.append(sortedSelections[0][0])
    return ans

def test(tcs):
    for tc in tcs:
        res = closestStraightCity(tc[0],tc[1],tc[2],tc[3])
        print(res)

tcs = [
    [['fastcity','bigbigbanana','xyz'],[23,23,23],[1,10,20],['fastcity','bigbigbanana','xyz']],
]
test(tcs)