import java.util.Stack;

//O(n^2) 풀이
//min[i] : i포함 왼쪽에 위치하는 값의 최소값
//i,j : i=1~n-1, j=i+1~n-1, check if nums[i] > nums[j] && min[i-1] < nums[j] : true 
// class Solution {
//     public boolean find132pattern(int[] nums) {
//         if (nums.length == 0) return false;
//         int[] minVal = new int[nums.length];
//         minVal[0] = nums[0];
//         for (int i=1; i<nums.length; i++){
//             minVal[i] = Math.min(nums[i],minVal[i-1]);
//         }
//         for (int i=1; i<nums.length; i++){
//             for (int j=i+1; j<nums.length; j++){
//                 if (nums[i] > nums[j] && minVal[i-1] < nums[j]) return true;
//             }
//         }
//         return false;
//     }
// }

//Brute Froce #1 O(n^3) --> fix (i,j,k) check if a[i] < a[k] < a[j]
//Brute Force #2 O(n^2) --> precalculate minVal from 0 to n-1, fix (j,k)
//O(n) 풀이 --> precalculate minVal, keep track of maximum value which is less than nums[j]
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n == 0) return false;
        int[] minVal = new int[n];
        minVal[0] = nums[0];
        for (int i=1; i<n; i++){
            minVal[i] = Math.min(nums[i],minVal[i-1]);
        }
        Stack<Integer> st = new Stack<>();
        for (int j = n-1; j > 0; j--){
            while(!st.empty() && nums[st.peek()] < nums[j]){
                if (nums[st.peek()] > minVal[j-1]) return true;
                st.pop();
            }
            st.push(j);
        }
        return false;
    }
}
