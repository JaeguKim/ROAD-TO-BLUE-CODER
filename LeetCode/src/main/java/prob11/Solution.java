package prob11;

public class Solution {
    // [ 1 3 2 5 25 24 5]
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while (l < r) {
            int h = Math.min(height[l],height[r]);
            maxArea = Math.max(maxArea,(r-l)*h);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return maxArea;
    }
}
