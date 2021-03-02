package com.leetcode.finderrornums;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                ans = num;
            }
            set.add(num);
        }
        for (int i=1;i<=nums.length;i++){
            if (!set.contains(i)){
                return new int[]{ans,i};
            }
        }
        return null;
    }
}