package 정수삼각형;

import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        for (int i=0;i<triangle.length;i++) {
            for (int j=0;j<triangle[i].length;j++) {
                int leftUpper = 0, rightUpper = 0;
                if (i-1 >= 0 && j-1 >= 0) leftUpper = dp[i-1][j-1];
                if (i-1 >= 0 && j < triangle[i-1].length) rightUpper = dp[i-1][j];
                dp[i][j] = Math.max(leftUpper,rightUpper) + triangle[i][j];
            }
        }
        return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
    }
}