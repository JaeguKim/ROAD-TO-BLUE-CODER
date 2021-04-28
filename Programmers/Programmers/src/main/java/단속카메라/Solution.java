package 단속카메라;

import java.util.*;

class Solution {

    public int solution(int[][] routes) {
       Arrays.sort(routes,(a,b)->Integer.compare(a[1],b[1]));
       int ans = 0;
       int last_pos = Integer.MIN_VALUE;
       for (int[] a : routes) {
           if (last_pos < a[0]) {
               ++ans;
               last_pos = a[1];
           }
       }
       return ans;
    }
}
