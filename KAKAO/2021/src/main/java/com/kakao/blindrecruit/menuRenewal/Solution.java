package com.kakao.blindrecruit.menuRenewal;

import java.util.*;

class Solution {

    List<String> list = new ArrayList<>();
    Map<String,Integer> map = new HashMap<>();
    Map<Integer,Integer> maxOrder = new HashMap<>();

    public void dfs(int idx, String s, String cur) {
        if (idx > s.length()) return;
        if (cur.length() >= 2) {
            map.put(cur,map.getOrDefault(cur,0)+1);
            maxOrder.put(cur.length(),Math.max(maxOrder.getOrDefault(cur.length(),0),map.get(cur)));
        }
        for (int i=idx; i<s.length(); i++) {
            dfs(i+1,s,cur+s.charAt(i));
        }
    }

    public String[] solution(String[] orders, int[] course) {
        for (String s : orders) {
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            dfs(0,new String(sorted),"");
        }
        Set<Integer> set = new HashSet<>();
        for (int c : course) {
            set.add(c);
        }
        for (String s : map.keySet()) {
            if (set.contains(s.length()) && map.get(s) >= 2 && map.get(s) == maxOrder.get(s.length())) {
                list.add(s);
            }
        }
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }
}
