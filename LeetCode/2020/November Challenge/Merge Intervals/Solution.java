import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] > b[0]){
                    return 1;
                }
                else if (a[0] == b[0]){
                    return 0;
                }
                else return -1;
            }
        });

        // OR
        //Arrays.sort(intervals,Comparator.comparingInt(o->o[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals){
            if (list.size() == 0){
                list.add(new int[]{interval[0],interval[1]});
                continue;
            }
            int[] last = list.get(list.size()-1);
            if (last[0] <= interval[0] && interval[0] <= last[1] && last[1] < interval[1]){
                list.remove((list.size()-1));
                list.add(new int[]{last[0], interval[1]});
            }
            else if (last[1] < interval[0]){
                list.add(new int[]{interval[0],interval[1]});
            }
        }

        return list.toArray(new int[0][]);
        //OR
        //return list.toArray(new int[list.size()][2]);
        
    }
}