package prob763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,int[]> mp = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<s.length(); ++i) {
            if (mp.containsKey(s.charAt(i))) {
                int[] interval = mp.get(s.charAt(i));
                interval[1] = i;
            } else {
                int[] newInterval = new int[]{i,i};
                mp.put(s.charAt(i), newInterval);
                list.add(newInterval);
            }
        }
        List<int[]> newList = new ArrayList<>();
        newList.add(list.get(0));
        for (int i=1; i<list.size(); ++i) {
            int[] lastInterval = newList.get(newList.size()-1);
            if (lastInterval[1] < list.get(i)[0]) {
                newList.add(list.get(i));
            } else {
                lastInterval[1] = Math.max(lastInterval[1],list.get(i)[1]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int[] interval : newList) {
            res.add(interval[1]-interval[0]+1);
        }
        return res;
    }
}
