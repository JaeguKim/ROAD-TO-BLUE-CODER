package prob121;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(5,sol.maxProfit(new int[]{7,1,5,3,6,4,}));
        Assert.assertEquals(0,sol.maxProfit(new int[]{7,6,4,3,1}));
    }
}
