package com.kakao.blindrecruit.taxifare;


class Solution {

    private final int INF = (int)Math.pow(10,8);

    public int[][] makeAdjMat(int n,int[][] fares) {
        int[][] mat = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) mat[i][j] = 0;
                else mat[i][j] = INF;
            }
        }
        for (int[] fare : fares) {
            mat[fare[0]-1][fare[1]-1] = fare[2];
            mat[fare[1]-1][fare[0]-1] = fare[2];
        }
        return mat;
    }

    public int[][] getMinCostMat(int[][] adjMat) {
        int n = adjMat.length;
        for (int k=0; k<n; k++){
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++) {
                    adjMat[i][j] = Math.min(adjMat[i][k]+adjMat[k][j],adjMat[i][j]);
                }
            }
        }
        return adjMat;
    }

    public int getMin(int s,int a, int b, int[][] minMat) {
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<minMat.length; i++) {
            ans = Math.min(ans,minMat[s-1][i]+minMat[i][a-1]+minMat[i][b-1]);
        }
        return ans;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] adjMat = makeAdjMat(n,fares);
        int[][] minMat = getMinCostMat(adjMat);
        return getMin(s,a,b,minMat);
    }
}