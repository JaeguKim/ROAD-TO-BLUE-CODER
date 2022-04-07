package prob923;

import java.util.Arrays;

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int N = arr.length;
        long MOD = (long) (1e9+7);
        int res = 0;
        for (int i=0; i<N; ++i) {
            int j=i+1,k=N-1;
            int remain = target-arr[i];
            while (j<k) {
                if (remain > arr[j]+arr[k]) j++;
                else if (remain < arr[j]+arr[k]) k--;
                else {
                    int s=j, e=k;
                    while (j<N-1 && arr[j] == arr[j+1]) j++;
                    while (k>0 && arr[k] == arr[k-1]) k--;
                    if (j < k) {
                        res += (j-s+1)*(e-k+1);
                    } else {
                        res += (e-s+1)*(e-s)/2;
                    }
                    res %= MOD;
                    System.out.println(res);
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
