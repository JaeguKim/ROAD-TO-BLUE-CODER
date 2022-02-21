package prob169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max = -1;
        int res = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                res = key;
                max = map.get(key);
            }
        }
        return res;
    }
}