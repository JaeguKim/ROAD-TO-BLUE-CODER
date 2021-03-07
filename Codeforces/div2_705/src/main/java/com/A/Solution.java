package com.A;

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDist = Integer.MAX_VALUE;
        int cnt = 0;
        int idx = 0;
        for (int i=0; i<points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                if (minDist > Math.abs(points[i][0]-x)+Math.abs(points[i][1]-y)) {
                    minDist = Math.abs(points[i][0]-x)+Math.abs(points[i][1]-y);
                    idx = i;
                }
                cnt++;
            }
        }
        if (cnt == 0) return -1;
        return idx;
    }
}
