#0-1 Knapsack problem과 비슷한 문제
#시간복잡도를 고려하지않아서 시간을 낭비하였다.
#sub-problem으로 나눌수 있는지가 dp로 풀수있는지 결정하는 기준이다.
def change(amount, coins):
    dp = []
    for i in range(len(coins)+1):    
        row = [0]*(amount+1)
        dp.append(row)
    for i in range(len(coins)+1):
        dp[i][0] = 1
    for i in range(1,len(coins)+1):
        for j in range(1,amount+1):
            newCnt = 0
            if j-coins[i-1] >= 0:
                newCnt = dp[i][j-coins[i-1]]
            dp[i][j] = dp[i-1][j]+newCnt
    return dp[len(coins)][amount]

res = change(5,[1,2,5])
print(res)
res = change(3,[2])
print(res)        
res = change(10,[10])
print(res)        
