package prob39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int sum, int idx) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(list));
        }
        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, list, candidates, target, sum + candidates[i], i);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }
}
