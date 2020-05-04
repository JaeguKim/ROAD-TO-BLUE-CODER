n = int(input())
heights = [int(ch) for ch in input().split()]
ans = 0
for i in range(len(heights)):
    h = heights[i]
    for j in range(i+h+1,len(heights)):
        interval = j-i
        sum = h+heights[j]
        if sum == interval:
            ans+=1
print(ans)

