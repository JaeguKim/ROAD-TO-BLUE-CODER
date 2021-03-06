package com.leetcode.marchchallenge.shortencodingofwords;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testFindLastChar() {
        Assert.assertEquals(solution.getLastPos("time", 'm'),2);
        Assert.assertEquals(solution.getLastPos("time",'a'),-1);
    }

    @Test
    public void testMinimumLengthEncoding() {
        Assert.assertEquals(10,solution.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        Assert.assertEquals(11,solution.minimumLengthEncoding(new String[]{"time", "a", "bell"}));
        Assert.assertEquals(2,solution.minimumLengthEncoding(new String[]{"t"}));
    }

    @Test
    public void testAppendString() {
        Assert.assertEquals("time",solution.appendString("time","me"));
        Assert.assertEquals("time#bell",solution.appendString("time","bell"));
    }
}
