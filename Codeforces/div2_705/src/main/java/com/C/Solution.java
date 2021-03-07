package com.C;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int beautySum(String s) {
        int ans = 0;
        for (int i=0; i<s.length(); i++) {
            Map<Character,Integer> map = new HashMap<>();
            int min = Integer.MAX_VALUE;
            char minCh = 0;
            int max = Integer.MIN_VALUE;
            char maxCh = 0;
            for (int j=i; j<s.length(); j++) {
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                int val = map.get(s.charAt(j));
                if (minCh != s.charAt(j) && val < min) {
                    min = Math.min(val,min);
                    minCh = s.charAt(j);
                }
                max = Math.max(val,max);
                ans += Math.abs(min-max);
            }
        }
        return ans;
    }
}
