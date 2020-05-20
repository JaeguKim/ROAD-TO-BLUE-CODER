import sys
from math import sqrt
input = sys.stdin.readline

############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

s=input()
length = len(s)
s+='*'
leftIdx = 0
rightIdx = 1
res = ''
isIdentical = False
isPrevIdentical = False
while leftIdx < length and rightIdx < len(s):
    if s[leftIdx] != s[rightIdx]:
        if isIdentical:
            if isPrevIdentical:
                res+=s[leftIdx]
            else:            
                res+=s[leftIdx]+s[leftIdx]
            isPrevIdentical = True
            isIdentical = False
        else:
            isPrevIdentical = False
            res+=s[leftIdx]
        leftIdx = rightIdx
        rightIdx = leftIdx+1
    else:
        isIdentical = True
        rightIdx += 1
print(res)