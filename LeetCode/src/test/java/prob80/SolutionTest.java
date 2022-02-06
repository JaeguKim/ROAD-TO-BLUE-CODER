package prob80;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        helper(new int[]{1,1,2,2,3,-1},5,new int[]{1,1,1,2,2,3});
        helper(new int[]{0,0,1,1,2,3,3,-1,-1},7,new int[]{0,0,1,1,1,1,2,3,3});
    }

    private void helper(int[] ans, int len, int[] input) {
        Solution sol = new Solution();
        int[] clone = input.clone();
        int res = sol.removeDuplicates(clone);
        Assert.assertEquals(len,res);
        for (int i=0; i<res; ++i) {
            Assert.assertEquals(ans[i],clone[i]);
        }
    }
}
