def getAns(n):
    if n == 1:
        return 1
    if n%2 == 0:
        return getAns(n//2)
    else:
        return getAns(n-1)+1

def solution(n):
    return getAns(n)
