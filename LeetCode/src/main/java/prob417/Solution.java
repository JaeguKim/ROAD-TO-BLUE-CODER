package prob417;

import java.util.*;

class Solution {

    int N,M;
    int[] dx = {0,0,0,1,-1};
    int[] dy = {0,1,-1,0,0};

    class Grid {
        int r,c;
        public Grid(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public boolean check(int N, int M) {
            return (r >= 0 && r < N && c >= 0 && c < M);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Grid grid = (Grid) o;
            return r == grid.r &&
                    c == grid.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public boolean bfs(int r, int c, int[][] heights) {
        Queue<Grid> que = new LinkedList<>();
        que.add(new Grid(r,c));
        Set<Grid> set = new HashSet<>();
        boolean isPacificVisited = false;
        boolean isAtlanticVisited = false;
        while (que.size() > 0) {
            if (isPacificVisited && isAtlanticVisited) break;
            Grid grid = que.poll();
            for (int i=0;i<5;i++) {
                Grid next = new Grid(grid.r + dx[i],grid.c + dy[i]);
                if (next.check(N,M) && heights[next.r][next.c] <= heights[grid.r][grid.c] && !set.contains(next)) {
                    if (next.r == 0 || next.c == 0) isPacificVisited = true;
                    if (next.r == N-1 || next.c == M-1) isAtlanticVisited = true;
                    set.add(next);
                    que.add(next);
                }
            }
        }
        return isPacificVisited && isAtlanticVisited;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        N = heights.length;
        M = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (bfs(i,j,heights)) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
}