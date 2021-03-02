import java.util.ArrayList;
import java.util.List;

// i = 0...n-1
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        List<String> res = new ArrayList<>();
        while (start < nums.length){
            if (start == nums.length-1){
                res.add(Integer.toString(nums[start]));
                break;
            }
            int cur = start+1;
            while (cur < nums.length && nums[cur] == nums[cur-1]+1){
                cur++;
            }
            if (nums[start] == nums[cur-1]){
                res.add(Integer.toString(nums[start]));
            }
            else {
                res.add(String.format("%d->%d",nums[start],nums[cur-1]));
            }
            start = cur;
        }
        return res;
    }
}
