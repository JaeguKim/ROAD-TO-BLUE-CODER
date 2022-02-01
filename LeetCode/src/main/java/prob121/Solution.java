package prob121;

class Solution {
    public int maxProfit(int[] prices) {
        int[] minArr = new int[prices.length];
        int[] maxArr = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i=0; i<prices.length; ++i) {
            min = Math.min(min,prices[i]);
            minArr[i] = min;
            max = Math.max(max,prices[prices.length-i-1]);
            maxArr[prices.length-i-1] = max;
        }
        int ans = 0;
        for (int i=0; i<prices.length; ++i) {
            ans = Math.max(ans,maxArr[i]-minArr[i]);
        }
        return ans;
    }
}
