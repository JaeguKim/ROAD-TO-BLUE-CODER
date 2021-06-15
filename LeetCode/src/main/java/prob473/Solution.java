package prob473;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private boolean helper(List<Integer> list,int idx,int[] sides,int len) {
        if (idx == list.size()) {
            if (sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3]) return true;
            return false;
        }
        for (int i=0; i<4; ++i) {
            sides[i] += list.get(idx);
            if (sides[i] <= len && helper(list,idx+1,sides,len)) return true;
            sides[i] -= list.get(idx);
        }
        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        List<Integer> list = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(list);
        Collections.reverse(list);
        if (sum % 4 != 0) return false;
        return helper(list,0,new int[4],sum/4);
    }
}
