package com.leetcode.marchchallenge.removepalindromicsubsequence;

import java.util.ArrayDeque;
import java.util.Deque;

// empty 0
//one type or palendrome -> 1
//a is even, b is even or a is odd, b is odd -> 2
//a is odd, b is even or a is even, b is odd -> 2
class Solution {
    public int removePalindromeSub(String s) {
       if (s.isEmpty()) return 0;
       boolean isPalandrome = true;
       for (int i=0;i<s.length()/2;i++) {
           if (s.charAt(i) != s.charAt(s.length()-1-i)) isPalandrome = false;
       }
       if (isPalandrome) return 1;
       return 2;
    }
}