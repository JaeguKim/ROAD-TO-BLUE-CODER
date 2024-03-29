package prob525;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 0, count = 0;
        map.put(0,-1);
        for (int i=0; i<nums.length; ++i) {
            count += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i-map.get(count));
            } else {
                map.put(count,i);
            }
        }
        return maxLen;
    }
}
