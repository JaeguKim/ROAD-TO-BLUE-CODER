#TIME : 
import sys
from math import sqrt
input = sys.stdin.readline

def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

N = inp()
data = []
for _ in range(N):
    name,lang,eng,math= input().split()
    data.append([name,int(lang),int(eng),int(math)])
sortedData = sorted(data,key=lambda x:(-x[1],x[2],-x[3],x[0]))
for item in sortedData:
    print(item[0])