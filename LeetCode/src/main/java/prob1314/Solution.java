package prob1314;

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] rangeSum = new int[n+1][m+1];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                rangeSum[i+1][j+1] = rangeSum[i][j+1] + rangeSum[i+1][j] - rangeSum[i][j] + mat[i][j];
            }
        }
        int[][] ans = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                int r1 = Math.max(0,i-k), r2 = Math.min(n-1,i+k), c1 = Math.max(0,j-k), c2 = Math.min(m-1,j+k);
                ans[i][j] = rangeSum[r2+1][c2+1] - rangeSum[r2+1][c1] - rangeSum[r1][c2+1] + rangeSum[r1][c1];
            }
        }
        return ans;
    }
}
