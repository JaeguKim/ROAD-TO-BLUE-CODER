package prob454;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(2,sol.fourSumCount(new int[]{1,2},new int[]{-2,-1},new int[]{-1,2}, new int[]{0,2}));
        Assert.assertEquals(1,sol.fourSumCount(new int[]{0},new int[]{0},new int[]{0}, new int[]{0}));
    }
}
