import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval implements Comparable<Interval>{
    int left;
    int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Interval o) {
        return left-o.left;
    }
}

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            list.add(new Interval(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(list);
        int left = 0;
        int right = 1;
        int ans = list.size();
        while (right < list.size()){
            Interval leftInterval = list.get(left);
            Interval rightInterval = list.get(right);
            if (leftInterval.left <= rightInterval.left && rightInterval.right <= leftInterval.right){
                ans--;
            }
            else if (rightInterval.left <= leftInterval.left && leftInterval.right <= rightInterval.right){
                ans--;
                left = right;
            }
            else {
                left = right;
            }
            right += 1;
        }
        return ans;
    }
}
