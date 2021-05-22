package prob350;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] cnt = new int[1001];
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) cnt[num]++;
        for (int num : nums2) {
            if (cnt[num] > 0) {
                cnt[num]--;
                list.add(num);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}