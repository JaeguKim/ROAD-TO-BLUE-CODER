package com.kakao.blindrecruit.menuRenewal;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        String[] res = sol.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        String[] expected = new String[]{"AC", "ACDE", "BCFG", "CDE"};
        for (int i=0;i<res.length;i++){
            Assert.assertEquals(expected[i],res[i]);
        }
    }
}
