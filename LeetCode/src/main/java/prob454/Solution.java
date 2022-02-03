package prob454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int k : nums3) {
            for (int l : nums4) {
                map.put(k+l,map.getOrDefault(k+l,0)+1);
            }
        }
        int ans = 0;
        for (int i=0;i<nums1.length;++i) {
            for (int j=0;j<nums2.length;++j) {
                    int target = (nums1[i]+nums2[j])*-1;
                    if (map.containsKey(target)) {
                        ans+=map.get(target);
                }
            }
        }
        return ans;
    }
}
