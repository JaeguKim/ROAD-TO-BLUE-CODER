package prob1351;

class Solution {
    public int countNegatives(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int r = N-1, c = 0;
        int cnt = 0;
        while (r >= 0 && c < M) {
            if (grid[r][c] < 0) {
                cnt += M-c;
                r--;
            } else {
                c++;
            }
        }
        return cnt;
    }
}