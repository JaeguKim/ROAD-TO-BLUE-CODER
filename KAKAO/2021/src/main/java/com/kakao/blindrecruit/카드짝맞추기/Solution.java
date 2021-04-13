package com.kakao.blindrecruit.카드짝맞추기;

import java.util.ArrayList;
import java.util.List;

class Card {
    int r;
    int c;
    int type;
    public Card(int r, int c, int type) {
        this.r = r;
        this.c = c;
        this.type = type;
    }
}

class Solution {

    public Card getCloseCard(List<Card> list, int r, int c) {
        int minDist = Integer.MAX_VALUE;
        Card ans = null;
        for (Card e : list) {
            int dist = getDist(e.r,r,e.c,c);
            if (minDist > dist) {
                minDist = dist;
                ans = e;
            }
        }
        return ans;
    }

    public int getDist(int r1, int c1, int r2, int c2) {
        return Math.min(Math.abs(r1-r2),Math.abs(c1-c2));
    }

    public int solution(int[][] board, int r, int c) {
        List<Card> cards = new ArrayList<>();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] != 0) {
                    cards.add(new Card(i,j,board[i][j]));
                }
            }
        }
        int curR = r, curC = c;
        int ans = 0;
        while (cards.size() > 0) {
            Card closeCard = getCloseCard(cards,curR,curC);
            Card pair = null;
            ans += getDist(curR,curC,closeCard.r,closeCard.c);
            for (Card card : cards) {
                if (card.type == closeCard.type && card.r != curR && card.c != curC) {
                    pair = card;
                    break;
                }
            }
            ans += getDist(curR,curC,pair.r,pair.c);
            curR = pair.r;
            curC = pair.c;
            cards.clear();
            System.out.printf("curR : %d, curC : %d, ans : %d\n",curR,curC,ans);
            for (Card card : cards) {
                if (pair.type != card.type) cards.add(card);
            }
        }
        return ans;
    }
}
