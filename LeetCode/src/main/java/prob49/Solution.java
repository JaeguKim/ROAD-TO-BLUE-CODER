package prob49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            //char[] arr = str.toCharArray();
            //Arrays.sort(arr);
            char[] arr = new char[26];
            for (char ch : str.toCharArray()) arr[ch-'a']++;
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                List<String> newList = new ArrayList<>();
                map.put(key,newList);
                res.add(newList);
            }
            map.get(key).add(str);
        }
        return res;
    }
}