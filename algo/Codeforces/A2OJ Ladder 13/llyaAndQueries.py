str = input()
n = len(str)
m = int(input())
dp = [[0]*(n+1) for i in range(n+1)]
for i in range(1,n):
    if str[i-1] == str[i]:
        dp[i][i+1] = 1
for i in range(2,n):
    for j in range(1,n+1):
        if j+i <= n:
            dp[j][j+i] = dp[j][j+i-1]+dp[j+1][j+i]
print(dp)
for i in range(m):
    l,r = map(int,input().split())
    print(dp[l][r])
    
        






