package prob1353;

import java.util.*;
import java.util.List;

public class Solution {

    class Event implements Comparable<Event> {
        int start, end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Event o) {
            if (end != o.end) return end - o.end;
            return start - o.start;
        }
    }

    public int maxEvents(int[][] events) {
        PriorityQueue<Event> pq = new PriorityQueue<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] event : events) {
            if (!map.containsKey(event[0])) {
                map.put(event[0], new ArrayList<>());
            }
            map.get(event[0]).add(event[1]);
        }
        int ans = 0;
        for (int t = 1; t <= 100000; t++) {
            if (map.containsKey(t)) {
                for (int e : map.get(t)) {
                    pq.add(new Event(t, e));
                }
            }
            if (pq.size() > 0) {
                while (pq.size() > 0 && t > pq.peek().end) {
                    pq.poll();
                }
                if (pq.size() > 0 && pq.peek().start <= t && t <= pq.peek().end) {
                    pq.poll();
                    ans++;
                }
            }
        }
        return ans;
    }
}