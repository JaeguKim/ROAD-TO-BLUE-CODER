package com.leetcode.stack.decodedStringAtIndex;

class Solution {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();
        for (int i=0;i<N;i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size *= c-'0';
            }
            else {
                size += 1;
            }
        }
        for (int i=S.length()-1;i>=0;i--) {
            char ch = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(ch)) {
                return ch+"";
            }
            if (Character.isDigit(ch)) {
                size /= (ch-'0');
            }
            else {
                size--;
            }
        }
        return "";
    }
}