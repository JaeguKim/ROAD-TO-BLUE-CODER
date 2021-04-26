package com.kakao.blindrecruit.카드짝맞추기;

public class Solution2 {
    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        boolean isExists[] = new boolean[7];
        int[][] pos = new int[7][4];
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board.length;j++) {
                if (board[i][j] != 0) {
                    if (isExists[board[i][j]]) {
                        pos[board[i][j]][2] = i;
                        pos[board[i][j]][3] = j;
                    }
                    else {
                        pos[board[i][j]][0] = i;
                        pos[board[i][j]][1] = j;
                    }
                    isExists[board[i][j]] = true;
                }
            }
        }

    }

    int minRoute(boolean isExists[], int[][] board, int r, int c, int tr, int tc, int m) {
        int min = Math.min(m,Math.abs(r-tr)+Math.abs(c-tc));
        if (tr == r && tc == c) return 0;
        if (min <= 0) return 10000;
        int offsets[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] offset : offsets) {
            if (isInRange(r+offset[0],c+offset[1])) {
                min = Math.min(min,minRoute(isExists,board,r+offset[0],c+offset[1],tr,tc,min-1)+1);
            }
            int temp_r = r+offset[0];
            int temp_c = r+offset[1];
            while (isInRange(temp_r+offset[0],temp_c+offset[1]) && !isExists[board[temp_r][temp_c]]) {
                temp_r += offset[0];
                temp_c += offset[1];
            }
            if (is)
        }
    }

    boolean isInRange(int r, int c) {
        return r<4 && r>=0 && c<4 && c>=0;
    }

    int recurse(int r, int c, boolean isExists[], int[][] pos, int[][] board) {
        int min = Integer.MAX_VALUE>>1;
        boolean flag = true;
        for (int n=1;n<=6;i++) {
            if (isExists[n]) {
                flag = false;
                int temp = 0;
                int temp0 = 0;
                //int temp1 =
            }
        }
    }
}
