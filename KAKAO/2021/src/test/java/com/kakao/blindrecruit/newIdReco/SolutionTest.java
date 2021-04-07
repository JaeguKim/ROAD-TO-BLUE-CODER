package com.kakao.blindrecruit.newIdReco;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSol() {
        Solution sol = new Solution();
        Assert.assertEquals(sol.solution("...!@BaT#*..y.abcdefghijklm"),"bat.y.abcdefghi");
        Assert.assertEquals(sol.solution("z-+.^."),"z--");
        Assert.assertEquals(sol.solution("=.="),"aaa");
        Assert.assertEquals(sol.solution("123_.def"),"123_.def");
        Assert.assertEquals(sol.solution("abcdefghijklmn.p"),"abcdefghijklmn");

        Assert.assertEquals(sol.regexpSolution("...!@BaT#*..y.abcdefghijklm"),"bat.y.abcdefghi");
        Assert.assertEquals(sol.regexpSolution("z-+.^."),"z--");
        Assert.assertEquals(sol.regexpSolution("=.="),"aaa");
        Assert.assertEquals(sol.regexpSolution("123_.def"),"123_.def");
        Assert.assertEquals(sol.regexpSolution("abcdefghijklmn.p"),"abcdefghijklmn");

    }

}
