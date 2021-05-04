package com.leetcode.stack.decodedStringAtIndex;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1() {
        Solution sol = new Solution();
        Assert.assertEquals("o",sol.decodeAtIndex("leet2code3",10));
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        Assert.assertEquals("h",sol.decodeAtIndex("ha22",5));
    }

    @Test
    public void test3() {
        Solution sol = new Solution();
        Assert.assertEquals("a",sol.decodeAtIndex("a2345678999999999999999",1));
    }
}
