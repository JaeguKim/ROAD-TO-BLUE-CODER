package com.leetcode.marchchallenge.shortencodingofwords;

class Solution {

    public int getLastPos(String from, char ch) {
        for (int i=from.length()-1; i>-1; i--) {
            if (from.charAt(i) == ch) return i;
        }
        return -1;
    }

    public String appendString(String s, String word) {
        int lastPos = getLastPos(s,word.charAt(0));
        if (lastPos != -1) {
            String lastStr = word.substring(lastPos);
            if (word.contains(lastStr)) {
                return s.substring(0,lastPos) + word;
            }
        }
        return s + "#" + word;
    }

    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0) return 0;
        String s = words[0];
        for (int i=1; i<words.length; i++) {
            s = appendString(s,words[i]);
        }
        s += "#";
        return s.length();
    }
}
