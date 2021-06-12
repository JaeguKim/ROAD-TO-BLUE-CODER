package prob871;

// 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        long[] dp = new long[stations.length+1];
        dp[0] = startFuel;
        for (int i=0; i<stations.length; ++i) {
            for (int t=i+1; t>=1 && dp[t-1] >= stations[i][0]; --t) {
                dp[t] = Math.max(dp[t],dp[t-1]+stations[i][1]);
            }
        }
        for (int i=0; i<=stations.length; ++i) {
            if (dp[i] >= target) return i;
        }
        return -1;
    }
}

