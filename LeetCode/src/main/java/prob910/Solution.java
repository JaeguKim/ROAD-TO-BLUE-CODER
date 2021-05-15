package prob910;

import java.util.Arrays;

class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int mn = A[0]+K, mx = A[A.length-1]-K, res = A[A.length-1]-A[0];
        for (int i=0;i<A.length-1;i++) {
            int curMx = Math.max(mx,A[i]+K);
            int curMn = Math.min(mn,A[i+1]-K);
            res = Math.min(res,curMx-curMn);
        }
        return res;
    }
}