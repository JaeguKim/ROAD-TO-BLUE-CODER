package Stone Game IV;

// dp array : n+1 size
// dp[0] = false;
// 1,4,9,..., k^2 <= n, if dp[n-k^2] == false, set true and break
// return dp[n]
// Time : O(nlog(n)), Space : n
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        for (int i=1; i<=n; i++){
            int base = 1;
            int square = 1;
            boolean res = false;
            while (square <= i){
                if (dp[i-square] == false){
                    res = true;
                    break;
                }
                base+=1;
                square = base*base;
            }
            dp[i] = res;
        }
        return dp[n];
    }
}