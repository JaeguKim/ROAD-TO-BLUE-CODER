package prob1774;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution sol = new Solution();

    @Test
    public void test1() {
        Assert.assertEquals(10,sol.closestCost(new int[]{1, 7}, new int[]{3, 4},10));
    }

    @Test
    public void test2() {
        Assert.assertEquals(17,sol.closestCost(new int[]{2,3},new int[]{4,5,100},18));
    }

    @Test
    public void test3() {
        Assert.assertEquals(10,sol.closestCost(new int[]{10},new int[]{1},1));
    }
}
