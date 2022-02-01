package prob46;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = sol.permute(nums);
        System.out.println(res);

        sol = new Solution();
        nums = new int[]{0,1};
        res = sol.permute(nums);
        System.out.println(res);

        sol = new Solution();
        nums = new int[]{1};
        res = sol.permute(nums);
        System.out.println(res);

    }
}
