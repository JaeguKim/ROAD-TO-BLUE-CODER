package prob1383;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] es = new int[n][2];
        for (int i=0; i<n; ++i) {
            es[i] = new int[]{efficiency[i],speed[i]};
        }
        Arrays.sort(es,(a,b) -> (Integer.compare(b[0],a[0])));
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(a,b) -> (Integer.compare(a,b)));
        long res = 0, sumS = 0;
        for (int i=0; i<n; ++i) {
            pq.add(es[i][1]);
            sumS += es[i][1];
            if (pq.size() > k) sumS -= pq.poll();
            res = Math.max(res,sumS*es[i][0]);
        }
        return (int) (res % (long)(1e9 + 7));
    }
}
