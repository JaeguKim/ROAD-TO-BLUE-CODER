def getStrongest(arr, k):
    pairs = []
    sortedArr = sorted(arr)
    m = sortedArr[int((len(sortedArr)-1)/2)]
    for i in range(len(arr)):
        pairs.append([abs(arr[i]-m),arr[i]])
  
    pairs = sorted(pairs,key=lambda x:(-x[0],-x[1]))
    res = []
    for i in range(k):
        res.append(pairs[i][1])
    return res

res = getStrongest([6,7,11,7,6,8],5)
#res = getStrongest([1,1,3,5,5],2)
#res = getStrongest([6,-3,7,2,11],3)
print(res)

# 1 3 5
# 6 7 8 11