class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int[] dp = new int[len];
        for (int i=0; i<len; i++) {
            if (flowerbed[i] == 1 && i > 0) {
                dp[i] = dp[i-1];
            }
            else if (flowerbed[i] == 0) {
                if ((i > 0 && flowerbed[i-1] == 1) || (i < len-1 && flowerbed[i+1] == 1) ) {
                    if (i == 0) {
                        dp[i] = 0;
                    }
                    else {
                        dp[i] = dp[i-1];                    
                    }
                }
                else {
                    if (i < 2) {
                        dp[i] = 1;
                    }
                    else {
                        dp[i] = dp[i-2]+1;
                    }
                }
            }
        }
        
        for (int i=0; i<len; i++){
            System.out.printf("%d ",dp[i]);
        }
        System.out.println();
        
        return dp[len-1] >= n ? true : false;
    }
}