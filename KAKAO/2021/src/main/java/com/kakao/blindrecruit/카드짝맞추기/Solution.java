package com.kakao.blindrecruit.카드짝맞추기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    ArrayList<int[]> orders;
    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,1,-1};

    void permutation(int[] visit, int s, int e) {
        if (s == e) {
            int[] temp = new int[visit.length];
            System.arraycopy(visit,0,temp,0,visit.length);
            orders.add(temp);
        }
        else {
            for (int i=s;i<=e;i++) {
                swap(visit,s,i);
                permutation(visit,s+1,e);
                swap(visit,s,i);
            }
        }
    }

    void swap(int[] visit, int i, int j) {
        int temp = visit[i];
        visit[i] = visit[j];
        visit[j] = temp;
    }

    int[] findCard(int[][] board, int r, int c, int d) {
        r += dr[d];
        c += dc[d];
        while (r >= 0 && r < 4 && c >= 0 && c < 4) {
            if (board[r][c] != 0) {
                return new int[]{r,c};
            }
            r += dr[d];
            c += dc[d];
        }
        return new int[]{r-dr[d],c-dc[d]};
    }

    int bfs(int[][] board, int target, int[] point) {
        int r = point[0];
        int c = point[1];
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        que.offer(new int[]{r,c,0});
        visited[r][c] = true;
        while (!que.isEmpty()) {
            int[] p = que.poll();
            if (board[p[0]][p[1]] == target) {
                point[0] = p[0];
                point[1] = p[1];
                return p[2];
            }
            for (int d=0;d<4;d++) {
                int nr = p[0]+dr[d];
                int nc = p[1]+dc[d];
                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr,nc,p[2]+1});
                }
            }

            for (int d=0;d<4;d++) {
                int[] result = findCard(board,p[0],p[1],d);
                if ((result[0] != p[0] || result[1] != p[1]) && !visited[result[0]][result[1]]) {
                    visited[result[0]][result[1]] = true;
                    que.offer(new int[]{result[0],result[1],p[2]+1});
                }
            }
        }
        return 0;
    }

    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        int n = 0;
        for (int[] row : board) {
            for (int e : row) {
                if (e != 0) n++;
            }
        }
        n /= 2;
        int[] temp = new int[n];
        for (int i=0;i<n;i++) {
            temp[i] = i+1;
        }
        orders = new ArrayList<>();
        permutation(temp,0,temp.length-1);
        for (int[] order : orders) {
            int total = 0;
            int[] point = new int[2];
            point[0] = r;
            point[1] = c;
            int[][] cBoard = new int[4][4];
            for (int i=0;i<4;i++) {
                for (int j=0;j<4;j++) {
                    cBoard[i][j] = board[i][j];
                }
            }
            for (int card : order) {
                int cnt = 0;
                cnt += bfs(cBoard,card,point) + 1;
                cBoard[point[0]][point[1]] = 0;
                cnt += bfs(cBoard,card,point) + 1;
                cBoard[point[0]][point[1]] = 0;
                total+=cnt;
            }
            answer = Math.min(total,answer);
        }
        return answer;
    }
}