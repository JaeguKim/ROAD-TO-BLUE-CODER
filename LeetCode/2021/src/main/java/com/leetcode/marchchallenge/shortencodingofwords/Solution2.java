package com.leetcode.marchchallenge.shortencodingofwords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int minimumLenghEncoding(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k=1; k<word.length(); k++) {
                good.remove(word.substring(k));
            }
        }
        int ans = 0;
        for (String word: good) {
            ans += word.length() + 1;
        }
        return ans;
    }
}
