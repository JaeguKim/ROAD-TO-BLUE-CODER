    p,b = map(int,input().split())
    segmentTree[2**n+p-1] = b
    i = 2**n+p-1
    while i != 1:
        parent = int(i/2)
        left = parent*2; right = parent*2+1
        if levels[parent] % 2 == 0:
            segmentTree[parent] = segmentTree[left] | segmentTree[right]
        else:
            segmentTree[parent] = segmentTree[left] ^ segmentTree[right]
        i = parent
    print(segmentTree[1])
