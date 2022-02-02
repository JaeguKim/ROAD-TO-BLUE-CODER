package prob438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        int[] cur_cnt_arr = new int[26];
        int[] p_cnt_arr = new int[26];
        for (int i=0; i<p.length(); ++i) {
            p_cnt_arr[p.charAt(i)-'a']++;
            cur_cnt_arr[s.charAt(i)-'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (isAnagram(cur_cnt_arr, p_cnt_arr)) {
            res.add(0);
        }
        for (int i=1; i<=s.length()-p.length(); ++i) {
            cur_cnt_arr[s.charAt(i-1)-'a']--;
            cur_cnt_arr[s.charAt(i+p.length()-1)]++;
            if (isAnagram(cur_cnt_arr, p_cnt_arr)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean  isAnagram(int[] cur_cnt_arr, int[] p_cnt_arr) {
        for (int i=0; i<26; ++i) {
            if (cur_cnt_arr[i] != p_cnt_arr[i]) return false;
        }
        return true;
    }
}
