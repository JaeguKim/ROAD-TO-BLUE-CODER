package prob153;

class Solution {
    // 3 4 5 1 2
    // 4 5 6 7 0 1 2
    // 2 1 3
    // 2 1 <- corner case인 경우를 생각할 것.
    public int findMin(int[] nums) {
        int ans = nums[0];
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = (l+r)/2;
            ans = Math.min(nums[mid],ans);
            if (nums[mid] >= nums[0]) l = mid+1;
            else r = mid-1;
        }
        return ans;
    }
}