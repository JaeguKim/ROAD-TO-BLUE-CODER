package prob435;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

    class myComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.end,o2.end);
        }
    }

    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // [1,2],[1,3],[3,4],[2,3]
    // [1,2] [1,3],[2,3],[3,4]
    // [[1,11] [2,12] [11 22] [1 100]
    public int eraseOverlapIntervals(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0],interval[1]));
        }
        Collections.sort(intervalList,new myComparator());
        int end = intervalList.get(0).end;
        int cnt = 1;
        for (int i=1;i<intervalList.size();i++) {
            Interval interval = intervalList.get(i);
            if (end <= interval.start) {
                cnt++;
                end = interval.end;
            }
        }
        return intervals.length-cnt;
    }
}