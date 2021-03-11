package com.leetcode.marchchallenge.coinChange;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution sol;

    @Before
    public void setup() {
        sol = new Solution();
    }

    @Test
    public void solveTest() {
        Assert.assertEquals(3,sol.coinChange(new int[]{1,2,5},11));
        Assert.assertEquals(-1,sol.coinChange(new int[]{2},3));
        Assert.assertEquals(0,sol.coinChange(new int[]{1},0));
        Assert.assertEquals(1,sol.coinChange(new int[]{1},1));
        Assert.assertEquals(2,sol.coinChange(new int[]{1},2));
    }
}
