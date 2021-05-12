package prob1353;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    Solution sol = new Solution();

    @Test
    public void test1() {
        Assert.assertEquals(3,sol.maxEvents(new int[][]{{1,2},{2,3},{3,4}}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4,sol.maxEvents(new int[][]{{1,2},{2,3},{3,4},{1,2}}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4,sol.maxEvents(new int[][]{{1,4},{4,4},{2,2},{3,4},{1,1}}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1,sol.maxEvents(new int[][]{{1,100000}}));
    }

    @Test
    public void test5() {
        Assert.assertEquals(7,sol.maxEvents(new int[][]{{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}}));
    }

    @Test
    public void test6() {
        Assert.assertEquals(5,sol.maxEvents(new int[][]{{1,2},{1,2},{3,3},{1,5},{1,5}}));
    }

    @Test
    public void test7() {
        Assert.assertEquals(5,sol.maxEvents(new int[][]{{1,5},{1,5},{1,5},{2,3},{2,3}}));
    }
}
