#TIME : 2hour
import re
import itertools

#sys.setrecursionlimit(10**6)
def recursion(permutation,expList,ans):
    if len(expList) == 3:
        exp = ''.join(expList)
        calc = eval(exp)
        ans[0] = max(ans[0],abs(calc))
        return
    idx = 0
    for i in range(len(permutation)):
        operator = permutation[i]
        if operator in expList:
            idx = expList.index(operator)-1
            break
    calcExp = ''.join(expList[idx:idx+3])
    calc = eval(calcExp)
    newExpList = []
    for item in expList[0:idx]:
        newExpList.append(item)
    newExpList.append(str(calc))
    if idx+3 < len(expList):
        for item in expList[idx+3:len(expList)]:
            newExpList.append(item)
    recursion(permutation,newExpList,ans)

def solution(expression):
    expList = re.split('(\+|\-|\*)',expression)
    operators = ['+','-','*']
    res = 0
    if len(expList) == 1:
        res = int(expList[0])
        return res
    ans = [0]
    permutations = list(itertools.permutations(operators))
    for permutation in permutations:
        recursion(permutation,expList,ans)
    return ans[0]

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = ["100-200*300-500+20", "50*6-3*2","30"]
test(tcs)