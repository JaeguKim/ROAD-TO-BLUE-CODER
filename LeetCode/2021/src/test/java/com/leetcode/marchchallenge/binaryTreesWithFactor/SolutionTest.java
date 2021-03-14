package com.leetcode.marchchallenge.binaryTreesWithFactor;

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
    public void test() {
        Assert.assertEquals(3,sol.numFactoredBinaryTrees(new int[]{2,4}));
        Assert.assertEquals(7,sol.numFactoredBinaryTrees(new int[]{2,4,5,10}));
        Assert.assertEquals(12,sol.numFactoredBinaryTrees(new int[]{18,3,6,2}));

    }

}
