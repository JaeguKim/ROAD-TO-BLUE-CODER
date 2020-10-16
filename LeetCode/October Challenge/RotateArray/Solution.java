package RotateArray;

// Solution 1
//offset = k%n 값이 0이면 그대로 리턴 아니면
//뒤에서 n-offset번째인수부터 n-1까지 배열에 저장, 0~n-offset-1까지 수를 배열에 저장
//새로만든 배열을 그대로 기존 배열에 복사한다
// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         int offset = k%n;
//         if (offset == 0) return;
//         int[] newArray = new int[n];
//         int idx = 0;
//         for (int i=n-offset; i<n; i++){
//             newArray[idx++] = nums[i];
//         }
//         for (int i=0; i<n-offset; i++){
//             newArray[idx++] = nums[i];
//         }
//         for (int i=0; i<n; i++){
//             nums[i] = newArray[i];
//         }
//     }
// }

//O(1) space solution
class Solution {
    public void rotate(int[] nums, int k) {
      k %= nums.length;
      reverse(nums, 0, nums.length - 1);
      reverse(nums, 0, k - 1);
      reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
      while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
      }
    }
  }