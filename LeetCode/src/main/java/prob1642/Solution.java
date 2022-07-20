package prob1642;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=1; i<heights.length; ++i) {
            int diff = heights[i]-heights[i-1];
            if (diff <= 0)
                continue;
            bricks -= diff;
            pq.add(diff);
            if (bricks < 0 && ladders == 0)
                return i-1;
            if (bricks < 0) {
                bricks += pq.poll();
                ladders -= 1;
            }
        }
        return heights.length-1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.furthestBuilding(new int[]{4,2,7,6,9,14,12},5,1);
        System.out.println(ans);
        ans = sol.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19},10,2);
        System.out.println(ans);
        ans = sol.furthestBuilding(new int[]{14,3,19,3},17,0);
        System.out.println(ans);
    }
}
