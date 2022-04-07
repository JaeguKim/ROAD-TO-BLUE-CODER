package prob31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int left = -1;
        for (int i=nums.length-2; i>=0; --i) {
            if (nums[i] < nums[i+1]) {
                left = i;
                break;
            }
        }
        if (left != -1) {
            for (int i=nums.length-1; i>left; i--) {
                if (nums[i] > nums[left]) {
                    int tmp = nums[left];
                    nums[left] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
        }
        Arrays.sort(nums,left+1,nums.length);
    }
}
