package prob1631;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int minimumEffortPath(int[][] heights) {

        int W = heights[0].length;
        int H = heights.length;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[][] memo = new int[H][W];

        for (int i=0; i<H; ++i) {
            for (int j=0; j<W; ++j) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        memo[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,0,0});
        while (pq.size() > 0) {
            int[] item = pq.poll();
            if (memo[item[1]][item[2]] < item[0]) continue;
            for (int i=0; i<4; ++i) {
                int newR = item[1] + dx[i];
                int newC = item[2] + dy[i];
                if (newR >= 0 && newR < H && newC >= 0 && newC < W) {
                    int newWeight = Math.max(memo[item[1]][item[2]],Math.abs(heights[newR][newC]-heights[item[1]][item[2]]));
                    if (memo[newR][newC] > newWeight) {
                        pq.add(new int[]{newWeight,newR,newC});
                        memo[newR][newC] = newWeight;
                    }
                }
            }
        }

        return memo[H-1][W-1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}}));
    }


}
