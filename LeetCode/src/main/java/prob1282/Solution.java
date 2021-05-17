package prob1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<groupSizes.length;i++) {
            if (map.containsKey(groupSizes[i]) == false) {
                map.put(groupSizes[i],new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
        }
        for (int key : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            for (int idx : map.get(key)) {
                list.add(idx);
                if (list.size() == groupSizes[idx]) {
                    res.add(list);
                    list = new ArrayList<>();
                }
            }
        }
        return res;
    }
}
