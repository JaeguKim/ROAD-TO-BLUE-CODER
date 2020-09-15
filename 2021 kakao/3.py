from collections import defaultdict
from bisect import bisect 

def getCount(curDict,queryData):
    cnt = 0
    if len(queryData) == 1:
        curDict.sort() 
        count = len(curDict) - bisect(curDict, int(queryData[0])-1) 
        return count
    if queryData[0] == '-':
        for key in curDict:
            cnt += getCount(curDict[key],queryData[1:])
    else:
        if queryData[0] not in curDict:
            return 0
        cnt += getCount(curDict[queryData[0]],queryData[1:])
    return cnt

def solution(info, query):
    searchDict = {}
    #print(info)
    for item in info:
        #print(item)
        infoStr = item.split(' ')
        #print(infoStr)
        curDict = searchDict
        for i,data in enumerate(infoStr):
            if i == 4:
                #print(searchDict)
                curDict.append(int(data))
                break
            if data not in curDict:
                if i == 3:
                    curDict[data] = []
                else:
                    curDict[data] = {}
            curDict = curDict[data]
    
    #print(searchDict)
    ans = []
    for q in query:
        queryStr = q.replace('and ','')
        #print(queryStr)
        queryStr = queryStr.split(' ')
        #print(queryStr)
        curDict = searchDict
        res = getCount(curDict,queryStr,)
        ans.append(res)
    return ans