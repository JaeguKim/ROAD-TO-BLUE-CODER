package prob1648;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    Solution sol = new Solution();

    @Test
    public void test1() {
        Assert.assertEquals(14,sol.maxProfit(new int[]{2,5},4));
    }

    @Test
    public void test2() {
        Assert.assertEquals(19,sol.maxProfit(new int[]{3,5},6));

    }

    @Test
    public void test3() {
        Assert.assertEquals(110,sol.maxProfit(new int[]{2,8,4,10,6},20));
    }

    @Test
    public void test4() {
        Assert.assertEquals(21,sol.maxProfit(new int[]{1000000000},1000000000));
    }

    @Test
    public void test5() {
        Assert.assertEquals(70267492,sol.maxProfit(new int[]{773160767},252264991));
    }
}
