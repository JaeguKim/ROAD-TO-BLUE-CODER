package prob532;

import java.util.*;

public class Solution {

    private boolean check(Map<Integer,List<Integer>> map, Set<String> set, int first, int second, int firstIdx) {
        String key = String.format("(%d,%d)",first,second);
        if (!set.contains(key) && map.containsKey(second)) {
            for (int i=map.get(second).size()-1; i>=0; --i) {
                int secondIdx = map.get(second).get(i);
                if (secondIdx > firstIdx) {
                    set.add(key);
                    return true;
                }
                else break;
            }
        }
        return false;
    }

    public int findPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<nums.length; ++i) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        int ans = 0;
        Set<String> set = new HashSet<>();
        for (int i=0; i<nums.length; ++i) {
            if (check(map,set,nums[i],nums[i]-k,i)) ans++;
            if (check(map,set,nums[i],nums[i]+k,i)) ans++;
        }
        return ans;
    }
}
