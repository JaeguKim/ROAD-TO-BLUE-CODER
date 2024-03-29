package prob33;

class Solution {
    // 6 7 0 1 2 4 5
    // 4 5 6 7 0 1 2
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) right = mid-1;
                else left = mid+1;
            }
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }
}
