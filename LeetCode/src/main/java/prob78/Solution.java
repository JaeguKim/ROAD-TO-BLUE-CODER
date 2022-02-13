package prob78;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recur(res, new ArrayList<>(),nums,0);
        return res;
    }

    private void recur(List<List<Integer>> list, List<Integer> curList, int[] nums, int cur) {
        if (cur == nums.length) {
            list.add(new ArrayList<>(curList));
            return;
        }
        curList.add(nums[cur]);
        recur(list,curList,nums,cur+1);
        curList.remove(curList.size()-1);
        recur(list,curList,nums,cur+1);
    }
}
