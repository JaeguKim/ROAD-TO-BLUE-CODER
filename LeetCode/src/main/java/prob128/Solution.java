package prob128;

import java.util.HashSet;
import java.util.Set;

// [100 4 200 1 3 2]
//
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) set.add(num);
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num-1) && !visited.contains(num)) {
                visited.add(num);
                int cur = num+1;
                int cnt = 1;
                while (set.contains(cur++)) {
                    visited.add(cur);
                    cnt++;
                }
                ans = Math.max(ans,cnt);
            }
        }
        return ans;
    }
}