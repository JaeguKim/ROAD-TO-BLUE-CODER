class Solution {
    public int longestMountain(int[] A) {
        int maxlen = 0;
        int n = A.length;
        if (n == 0){
            return 0;
        }
        int[] ascDp = new int[n];
        int[] descDp = new int[n];
        for (int i=1;i<n;i++){
            if (A[i-1] < A[i]){
                ascDp[i] = ascDp[i-1]+1;
            }
        }
        for (int i=n-2;i>-1;i--){
            if (A[i] > A[i+1]){
                descDp[i] = descDp[i+1]+1;
            }
        }
        for (int i=0;i<n;i++){
            if (ascDp[i] != 0 && descDp[i] != 0){
                maxlen = Math.max(maxlen,ascDp[i]+descDp[i]+1);
            }
        }
        return maxlen;
    }
}
