package 입국심사;

import java.util.Arrays;

// int * int = int
public class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int len = times.length;
        long high = (long)times[len-1]*n;
        long low = 0;
        long answer = Long.MAX_VALUE;
        while (low <= high) {
            long mid = (low+high)/2;
            long cnt = 0;
            for (int time : times) {
                cnt += mid/time;
            }
            if (cnt >= n) {
                answer = Math.min(answer,mid);
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return answer;
    }
}
