
public class Solution {

    public int getSum(int[] nums,int divisor){
        int sum = 0;
        for (int num:nums){
            sum += Math.ceil(num/(double)divisor);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int maxVal = Integer.MIN_VALUE;
        for (int num:nums){
            maxVal = Math.max(num,maxVal);
        }
        int right = maxVal;
        int ans = 0;
        while (left <= right){
            int middle = (left+right)/2;
            int curSum = getSum(nums,middle);
            if (curSum <= threshold){
                right = middle-1;
                ans = middle;
            }
            else {
                left = middle+1;
            }
        }
        return ans;
    }

}
