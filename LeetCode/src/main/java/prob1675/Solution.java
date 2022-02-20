package prob1675;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            int insertNum = num % 2 == 1 ? num*2 : num;
            min = Math.min(min,insertNum);
            max = Math.max(max,insertNum);
            pq.add(insertNum);
        }
        int min_dev = max-min;
        while (pq.peek() % 2 == 0) {
            int top = pq.poll() / 2;
            min = Math.min(min,top);
            pq.add(top);
            min_dev = Math.min(min_dev,pq.peek()-min);
        }
        return min_dev;
    }
}
