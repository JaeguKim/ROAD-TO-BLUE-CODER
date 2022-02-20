package prob1288;

import java.util.*;

public class Solution {

    private class Interval implements Comparable<Interval> {
        private int l;
        private int r;

        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Interval o) {
            if (l < o.l || l == o.l && r > o.r) return -1;
            else if (l == o.l && r == o.r) return 0;
            else return 1;
        }
    }

    public int removeCoveredIntervals(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(list);
        Interval prev = list.get(0);
        int cnt = 1;
        for (int i = 1; i < list.size(); ++i) {
            Interval cur = list.get(i);
            if (cur.l <= prev.r && cur.r > prev.r) {
                prev.r = cur.r;
                cnt++;
            } else if (cur.l > prev.r && cur.r > prev.r) {
                prev = cur;
                cnt++;
            }
        }
        return cnt;
    }
}
