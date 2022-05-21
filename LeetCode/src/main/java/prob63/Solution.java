package prob63;

public class Solution {

    private int[][] obsGrid;
    private boolean[][] visited;
    private int ans;
    private int M;
    private int N;
    private int[][] dirs = {{0,1},{1,0}};

    public int uniquePathsWithObstaclesDFS_TLE(int[][] obstacleGrid) {
        obsGrid = obstacleGrid;
        M = obstacleGrid.length;
        N = obstacleGrid[0].length;
        visited = new boolean[M][N];
        ans = 0;
        if (obstacleGrid[0][0] == 0)
            dfs(0,0);
        return ans;
    }

    public void dfs(int r, int c) {
        if (r == M-1 && c == N-1) {
            ans++;
            return;
        }
        visited[r][c] = true;
        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR >= 0 && newR < M && newC >= 0 && newC < N) {
                if (obsGrid[newR][newC] == 0 && !visited[newR][newC])
                    dfs(newR,newC);
            }
        }
        visited[r][c] = false;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R - 1][C - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
        System.out.println(res);
        res = sol.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}});
        System.out.println(res);
    }
}
