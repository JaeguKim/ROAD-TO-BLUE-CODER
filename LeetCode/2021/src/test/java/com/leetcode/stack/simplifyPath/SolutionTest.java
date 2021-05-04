package com.leetcode.stack.simplifyPath;

import com.leetcode.stack.simplifyPath.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1() {
        Solution sol = new Solution();
        Assert.assertEquals("/home",sol.simplifyPath("/home/"));
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        Assert.assertEquals("/",sol.simplifyPath("/../"));
    }

    @Test
    public void test3() {
        Solution sol = new Solution();
        Assert.assertEquals("/home/foo",sol.simplifyPath("/home//foo/"));
    }

    @Test
    public void test4() {
        Solution sol = new Solution();
        Assert.assertEquals("/c",sol.simplifyPath("/a/./b/../../c/"));
    }

    @Test
    public void test5() {
        Solution sol = new Solution();
        Assert.assertEquals("/...",sol.simplifyPath("/.../"));
    }

    @Test
    public void test6() {
        Solution sol = new Solution();
        Assert.assertEquals("/...",sol.simplifyPath("/..."));
    }

    @Test
    public void test7() {
        Solution sol = new Solution();
        Assert.assertEquals("/c",sol.simplifyPath("/a/../../b/../c//.//"));
    }
}
