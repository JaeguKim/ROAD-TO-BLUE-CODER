package prob165;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
//        Assert.assertEquals(0,sol.compareVersion("1.01","1.001"));
//        Assert.assertEquals(0,sol.compareVersion("1.0","1.0.0"));
        Assert.assertEquals(-1,sol.compareVersion("0.1","1.1"));
    }
}
