package prob3;

import java.util.HashSet;
import java.util.Set;

class Solution {

    // SET : b
    // a b c a b c b b
    // ""
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}