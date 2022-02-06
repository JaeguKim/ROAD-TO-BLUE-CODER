package prob80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int insertIdx = 1;
        int cnt = 1;
        for (int i=1; i<nums.length; ++i) {
            if (nums[i] == nums[i-1]) {
                cnt++;
                if (cnt <= 2) {
                    nums[insertIdx++] = nums[i];
                }
            } else {
                nums[insertIdx++] = nums[i];
                cnt = 1;
            }
        }
        return insertIdx;
    }
}
