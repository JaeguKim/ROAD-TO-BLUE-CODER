import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums){
            total += num;
        }
        if (total % 2 != 0){
            return false;
        }

        return canPartition(nums,total,0,0,new HashMap<>());
    }

    public boolean canPartition(int[] nums, int total, int index, int sum, Map<String,Boolean> map) {
        String key = String.format("%d|%d",index,sum);
        if (index >= nums.length || sum > total/2) {
            return false;
        }
        if (map.containsKey(key)){
            return map.get(key);
        }
        if (sum * 2 == total) { 
            return true;
        }
        boolean result = canPartition(nums,total,index+1,sum+nums[index],map) || canPartition(nums,total,index+1,sum,map);
        map.put(key,result);
        return result;
    }
}