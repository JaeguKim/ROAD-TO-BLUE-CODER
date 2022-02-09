package prob532;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(2,sol.findPairs(new int[]{3,1,4,1,5},2));
        Assert.assertEquals(4,sol.findPairs(new int[]{1,2,3,4,5},1));
        Assert.assertEquals(1,sol.findPairs(new int[]{1,3,1,5,4},0));
    }
}
