package prob47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<String,List<Integer>> resMp;

    public List<List<Integer>> permuteUnique(int[] nums) {
        resMp = new HashMap<>();
        Map<Integer,Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        recur(mp,new ArrayList<>(),nums.length);
        return resMp.values().stream().toList();
    }

    private void recur(Map<Integer,Integer> mp, List<Integer> li, int sz) {
        if (li.size() == sz) {
            StringBuilder sb = new StringBuilder();
            for (Integer e : li) {
                sb.append(e+"-");
            }
            resMp.put(sb.toString(),new ArrayList<>(li));
            return;
        }
        for (int key : mp.keySet()) {
            if (mp.get(key) > 0) {
                int backup = mp.get(key);
                mp.put(key,backup-1);
                li.add(key);
                recur(mp,li,sz);
                mp.put(key,backup);
                li.remove(li.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> res = sol.permuteUnique(new int[]{1,1,2});
        for (List<Integer> e : res) {
            System.out.println(e);
        }
        res = sol.permuteUnique(new int[]{1,2,3});
        for (List<Integer> e : res) {
            System.out.println(e);
        }
    }
}
