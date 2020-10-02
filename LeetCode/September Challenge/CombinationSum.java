import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class CombinationSum {

    List<List<Integer>> result;
    HashSet<String> hashSet;

    public void helper(List<Integer> list, int[] candidates, int target, int sum, int idx) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(list));
        }
        for (int i = idx; i < candidates.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(candidates[i]);
            helper(newList, candidates, target, sum + candidates[i], i);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }
}