import java.util.Arrays;

//dp를 k+1,n+1로 선언 => 메모리 초과
//dp[i][j] = max(dp[i][j-1], prices[j]-prices[m]+dp[i-1][m-1] for m=0~j-1)
//keep track of max of prices[j]-prices[m]
// 
class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k == 0 || n == 0) return 0;
        if (k >= n-1) {
            return allTimeProfit(prices);
        }
        
        int[] prev = new int[n+1];
        int[] cur = new int[n+1];
        for (int i=1; i<=k; i++){
            int maxDiff = Integer.MIN_VALUE;
            for (int j=2; j<=n; j++){
                maxDiff = Math.max(maxDiff,prev[j-2]-prices[j-2]);
                cur[j] = Math.max(cur[j-1],prices[j-1]+maxDiff);
            }
            prev = Arrays.copyOf(cur,n+1);
        }
        // for (int i=0; i<=k; i++){
        //     for (int j=0; j<=n; j++){
        //         System.out.printf("%d ",dp[i][j]);
        //     }
        //     System.out.println();
        // }

        return cur[n];
    }
    
    public int allTimeProfit(int arr[]){
        int profit = 0;
        int localMin = arr[0];
        for(int i=1; i < arr.length;i++){
            if(arr[i-1] >= arr[i]){
                localMin = arr[i];
            }else{
                profit += arr[i] - localMin;
                localMin = arr[i];
            }

        }
        return profit;
    }
}