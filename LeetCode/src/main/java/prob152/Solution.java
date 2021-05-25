package prob152;

/*
    [2 3 -2 4]
    [2 3 -12 -48]
    [2 6 -2 4]

    [-2 0 -1]
    [-2 0 -1
    [-2 0 0]

 */

class Solution {
    public int maxProduct(int[] nums) {
        int[] minArr = new int[nums.length];
        int[] maxArr = new int[nums.length];
        minArr[0] = nums[0];
        maxArr[0] = nums[0];
        int ans = maxArr[0];
        for (int i=1;i<nums.length;i++) {
            minArr[i] = Math.min(nums[i],Math.min(nums[i]*minArr[i-1],nums[i]*maxArr[i-1]));
            maxArr[i] = Math.max(nums[i],Math.max(nums[i]*minArr[i-1],nums[i]*maxArr[i-1]));
            ans = Math.max(maxArr[i],ans);
        }
        return ans;
    }
}