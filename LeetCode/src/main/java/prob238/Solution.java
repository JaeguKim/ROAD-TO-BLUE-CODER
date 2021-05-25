package prob238;

//[ 10 20 30 40 ]
//[ 1 10 200 6000]
//[240000 24000 1200 40]
//[1*24000 10 * 24000 200* 1200 6000 * 40]

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int n = nums.length;
        answer[0] = 1;
        for (int i=1;i<n;i++) answer[i] = answer[i-1]*nums[i-1];
        int right = 1;
        for (int i=n-2;i>=0;i--) {
            right *= nums[i+1];
            answer[i] = answer[i]*right;
        }
        return answer;
    }
}