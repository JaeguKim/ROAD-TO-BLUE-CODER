class Solution {
    public int[] solution(String[] info, String[] query) {
        serachDict = new Node();
        for(String item : info){
            String[] infoStr = item.split(" ");
            curDict = searchDict;
            List<Integer> numList;
            for (int i=0; i<infoStr.length){
                if (i == 4){
                    numList.add(Integer(data));
                    break;
                }
                if (infoStr[i])
            }
        }
        int[] answer = {};
        return answer;
    }
}

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