package prob46;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private List<List<Integer>> resList = new ArrayList<>();

    public void recur(int[] nums, Set<Integer> containedNumSet, List<Integer> tmpList) {
        if (tmpList.size() == nums.length) {
            resList.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i=0; i<nums.length; ++i) {
            if (!containedNumSet.contains(nums[i])) {
                containedNumSet.add(nums[i]);
                tmpList.add(nums[i]);
                recur(nums,containedNumSet,tmpList);
                tmpList.remove(tmpList.size()-1);
                containedNumSet.remove(nums[i]);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        recur(nums,new HashSet<>(),new ArrayList<>());
        return resList;
    }
}
