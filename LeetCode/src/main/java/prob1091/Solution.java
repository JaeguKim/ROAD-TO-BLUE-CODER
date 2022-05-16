package prob1091;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[][] dp = new int[N][M];
        int[][] dirs = {{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1}};
        boolean[][] visited = new boolean[N][M];
        for (int i=0;i<N;++i)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[0][0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        if (grid[0][0] == 0)
            pq.add(new int[]{0,0,1});
        while (!pq.isEmpty()) {
            int[] curPos = pq.poll();
            for (int[] dir : dirs) {
                int[] newPos = new int[]{curPos[0]+dir[0],curPos[1]+dir[1]};
                if (checkBound(newPos[0],newPos[1],N,M)) {
                    if (!visited[newPos[0]][newPos[1]] && grid[newPos[0]][newPos[1]] == 0 && dp[curPos[0]][curPos[1]]+1 < dp[newPos[0]][newPos[1]]) {
                        int newVal = dp[curPos[0]][curPos[1]]+1;
                        dp[newPos[0]][newPos[1]] = newVal;
                        visited[newPos[0]][newPos[1]] = true;
                        pq.add(new int[]{newPos[0],newPos[1],newVal});
                    }
                }
            }
        }
        return dp[N-1][M-1] == Integer.MAX_VALUE ? -1 : dp[N-1][M-1];
    }

    private boolean checkBound(int r, int c, int N, int M) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //System.out.println(sol.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        //System.out.println(sol.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        //System.out.println(sol.shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
        System.out.println(sol.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,0,0},{1,1,0}}));
    }
}
