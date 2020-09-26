class Solution:
    
    def solve(self):
        n,k = [int(num) for num in input().split()]
        ary = [int(num) for num in input().split()]
        left = 0; right = left; summ = 0
        ans = 0
        while left < n and right < n:
            summ += ary[right]
            if summ >= k:
                if summ == k:
                    ans += 1
                left += 1; right = left; summ = 0
            else:
                right += 1
        print(ans)
Solution().solve()