package prob300;

class Solution {

    public int findIdx(int[] dp,int num,int size) {
        int i=0,j=size-1;
        while (i<=j) {
            int mid = (i+j)/2;
            if (dp[mid] < num) i = mid+1;
            else j = mid-1;
        }
        return i;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int idx = findIdx(dp,num,size);
            dp[idx] = num;
            if (idx == size) {
                size++;
            }
        }
        return size;
    }
}