package prob525;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(2,sol.findMaxLength(new int[]{0,1}));
        Assert.assertEquals(2,sol.findMaxLength(new int[]{0,1,0}));
        Assert.assertEquals(6,sol.findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
    }
}
