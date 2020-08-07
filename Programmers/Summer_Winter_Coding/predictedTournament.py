def convertNum(num):
    return num//2 if num%2 == 0 else (num+1)//2

def solution(n,a,b):
    answer = 0
    curA = min(a,b); curB = max(a,b)
    while curA != curB:
        curA = convertNum(curA)
        curB = convertNum(curB)
        answer+=1
    return answer