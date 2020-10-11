def toStr(n,base):
   convertString = "0123456789ABCDEF"
   if n < base:
      return convertString[n]
   else:
      return toStr(n//base,base) + convertString[n%base]

def swap(num):
    numList = [ch for ch in str(num)]
    temp = numList[0]
    numList[0] = numList[-1]
    numList[-1] = temp
    return ''.join(numList)

def convertToDecimal(str):
    res = 0
    offset = 0
    for i in range(len(str)-1,-1,-1):
        res += int(str[i]) * pow(3,offset)
        offset += 1
    return res

def solution(n):
    tenary = toStr(n,3)
    #print(tenary)
    ans = tenary[::-1]
    #print(ans)
    return convertToDecimal(ans)

res = solution(45)
print(res)