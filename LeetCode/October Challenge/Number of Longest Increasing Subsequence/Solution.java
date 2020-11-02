package Number

import java.util.HashMap;

of Longest Increasing Subsequence;

//맨뒤에 숫자부터 시작
//idx i위치의수를 가지고 만들수 있는 가장 긴 수열의 길이 -> maxLenDP[i]
//idx i위치의수를 가지고 만들수 있는 가장 긴 수열의 갯수 -> cntMemo[i]
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] maxLenDP = new int[n];
        int[] cntMemo = new int[n];
        HashMap<Integer, Integer> lengthHash = new HashMap<>();
        int globalMaxLen = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 1;
            int maxLen = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    if (maxLen < maxLenDP[j] + 1) {
                        maxLen = maxLenDP[j] + 1;
                        cnt = cntMemo[j];
                    }
                    else if (maxLen == maxLenDP[j]+1){
                        cnt += cntMemo[j];
                    }
                }
            }
            maxLenDP[i] = maxLen;
            cntMemo[i] = cnt;
            lengthHash.put(maxLen,lengthHash.getOrDefault(maxLen,0)+cnt);
            globalMaxLen = Integer.max(globalMaxLen,maxLen);
        }
        
        for (int i=0; i<n; i++){
            System.out.printf("%d ",maxLenDP[i]);
        }
        System.out.println();
        for (int i=0; i<n; i++){
            System.out.printf("%d ",cntMemo[i]);
        }

        return lengthHash.get(globalMaxLen);
    }
}