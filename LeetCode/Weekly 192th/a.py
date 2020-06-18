def shuffle(nums, n):
    left = 0
    right = n
    res = []
    for i in range(n):
        res.append(nums[left+i])
        res.append(nums[right+i])
    return res

res = shuffle([2,5,1,3,4,7],3)
res = shuffle([1,2],1)
res  =shuffle()
print(res)  