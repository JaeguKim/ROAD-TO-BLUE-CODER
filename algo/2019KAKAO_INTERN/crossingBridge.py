def solution(stones, k):
    n = len(stones)
    ans = 0
    prevMax = max(stones[0:k])
    front = stones[0]
    for i in range(1,n-k+1):
        localMax = max(max(front,stones[i+k-1]),prevMax)
        print(localMax)
        ans = min(localMax,prevMax)
        front = stones[i]
        prevMax = localMax
            
    return ans

print(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3))