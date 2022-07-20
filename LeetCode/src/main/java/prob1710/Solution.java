package prob1710;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        int remain = truckSize;
        int total = 0;
        for (int i=0; i<boxTypes.length; ++i) {
            int pickCnt = Math.min(boxTypes[i][0],remain);
            total += pickCnt * boxTypes[i][1];
            remain -= pickCnt;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.maximumUnits(new int[][]{{1,3},{2,2},{3,1}},4);
        System.out.println(res);
        res = sol.maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}},10);
        System.out.println(res);
    }
}
