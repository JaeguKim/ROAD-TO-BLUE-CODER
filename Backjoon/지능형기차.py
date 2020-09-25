class Solution:
    
    def solve(self):
        cnt = 0
        ans = 0
        for _ in range(10):
            input_list = [int(num) for num in input().split()]
            cnt -= input_list[0]; cnt += input_list[1]
            ans = max(ans,cnt)
        print(ans)
    
Solution().solve()