package com.kakao.blindrecruit.카드짝맞추기;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {

    @Test
    public void test1() {
        int[][] board = new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        Solution sol = new Solution();
        Assert.assertEquals(14,sol.solution(board,1,0));
    }

    public void test2() {
        int[][] board = new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
        Solution sol = new Solution();
        Assert.assertEquals(16,sol.solution(board,0,1));
    }
}
