package com.kakao.blindrecruit.카드짝맞추기;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import com.kakao.blindrecruit.카드짝맞추기.Card;


public class SolutionTest {

    @Test
    public void getCloseCardTest() {
        List<Card> list = new ArrayList<>();
        list.add(new Card(0,0,0));
        list.add(new Card(1,0,1));
        list.add(new Card(3,0,2));
        Solution sol = new Solution();
        Card ans = sol.getCloseCard(list,1,0);
        //Assert.assertEquals(1,ans.r);
        Assert.assertEquals(0,ans.c);
    }

    @Test
    public void solutionTest() {
        int[][] board = new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        Solution sol = new Solution();
        Assert.assertEquals(14,sol.solution(board,1,0));
        board = new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
        Assert.assertEquals(16,sol.solution(board,0,1));
    }
}
