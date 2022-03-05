package prob740;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(6,sol.deleteAndEarn(new int[]{3,4,2}));
        Assert.assertEquals(9,sol.deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
