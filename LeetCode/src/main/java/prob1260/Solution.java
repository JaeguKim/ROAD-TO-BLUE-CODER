package prob1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int M = grid.length, N = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();
        Integer[][] newArr = new Integer[M][N];
        for (int i=0;i<M;++i) {
            for (int j=0;j<N;++j) {
                int newR = (i+(j+k)/N)%M;
                int newC = (j+k)%N;
                newArr[newR][newC] = grid[i][j];
            }
        }
        for (int i=0; i<M; ++i) {
            res.add(Arrays.asList(newArr[i]));
        }
        return res;
    }
}
