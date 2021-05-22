package prob1;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
        }
        int[] ans = null;
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i) ans = new int[]{i,map.get(target-nums[i])};
        }
        return ans;
    }
}