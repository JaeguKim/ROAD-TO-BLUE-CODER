package com.D;

class Solution {
    public boolean checkOnesSegment(String s) {
        boolean flag = false;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (flag == false && c == '1') {
                cnt++;
                flag = true;
            } else if (flag && c == '0') {
                flag = false;
            }
        }
        return cnt == 1;
    }
}