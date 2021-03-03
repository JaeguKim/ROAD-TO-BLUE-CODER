package com.leetcode.marchchallenge.distributecandies;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        int size = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int elem : candyType) {
            set.add(elem);
        }
        int type = set.size();
        return Math.min(size/2,type);
    }
}