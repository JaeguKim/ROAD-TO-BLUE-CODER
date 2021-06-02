package prob347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    // 1 1 1 2 2 2 3 3 3, k = 2
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for (int n : nums) map.put(n,map.getOrDefault(n,0)+1);
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=bucket.length-1; i>=0; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) ans.add(num);
            }
        }

        return ans.subList(0,k).stream().mapToInt(i->i).toArray();
    }
}
