package prob581;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copied = nums.clone();
        Arrays.sort(copied);
        int l = nums.length,r = 0;
        for (int i=0; i<nums.length; ++i) {
            if (nums[i] != copied[i]) {
                l = Math.min(l,i);
                r = Math.max(r,i);
            }
        }
        int len = r-l+1;
        return len > 1 ? len : 0;
    }

    public int linearSolution(int[] nums) {
        int length = nums.length;
        int max = 0,min = 0;
        int l=length-1,r=0;
        for (int i=0; i<length; ++i) {
            if (i == 0)
                max = nums[i];
            else
                max = Math.max(max,nums[i]);
            if (nums[i] != max)
                r = Math.max(r,i);
        }
        for (int i=length-1; i>-1; --i) {
            if (i == length-1)
                min = nums[i];
            else
                min = Math.min(min,nums[i]);
            if (nums[i] != min)
                l = Math.min(l,i);
        }
        int len = r-l+1;
        return len > 1 ? len : 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //System.out.println(sol.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println(sol.linearSolution(new int[]{2,6,4,8,10,9,15}));
    }
}