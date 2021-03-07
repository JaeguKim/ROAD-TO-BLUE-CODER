package com.B;

class Solution {
    int countWaysUtil(int x, int n, int num)
    {
        int val = (int) (x - Math.pow(n, num));
        if (val == 0)
            return 1;
        if (val < 0)
            return 0;
        return countWaysUtil(val, n, num + 1) +
                countWaysUtil(x, n, num + 1);
    }

    public boolean checkPowersOfThree(int n) {
        if (countWaysUtil(n,3,0) == 0) {
            return false;
        }
        return true;
    }
}