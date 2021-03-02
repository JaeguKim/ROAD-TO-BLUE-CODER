class SubarrayProductLessThanK{
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int mult = 1;
        int ans = 0;
        while (right < nums.length){
            mult *= nums[right];
            if (mult < k){
                ans += (right-left)+1;
                right += 1;
            }
            else {
                mult /= nums[right];
                if (left == right){
                    left += 1;
                    right = left;
                }
                else {
                    mult /= nums[left];
                    left += 1;
                }
            }
        }
        return ans;
    }
}