package prob456;

import java.util.Stack;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int N = nums.length;
        if (N < 3) return false;
        int[] min = new int[N];
        min[0] = nums[0];
        Stack<Integer> st = new Stack<>();
        for (int i=1; i<N; ++i)
            min[i] = Math.min(min[i-1],nums[i]);
        for (int i=N-1; i>0; --i) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                if (min[i-1] < nums[st.peek()]) return true;
                st.pop();
            }
            st.push(i);
        }
        return false;
    }

    public boolean faster_find132pattern(int[] nums) {
        int second = Integer.MIN_VALUE;
        int index = nums.length; //using nums itself as the stack (bottom on the right end)
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) return true;
            else while (index < nums.length && nums[i] > nums[index]) second = nums[index++];
            nums[--index] = nums[i];
        }
        return false;
    }
}
