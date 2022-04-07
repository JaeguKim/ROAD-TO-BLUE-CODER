package prob1046;

import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(a,b)*-1);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.add(x-y);
            }
        }
        return (pq.size() == 0) ? 0 : pq.poll();
    }
}
