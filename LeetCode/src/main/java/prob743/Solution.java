package prob743;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];
        int[] memo = new int[n];
        Arrays.fill(memo,Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i)
            Arrays.fill(graph[i], -1);
        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        boolean[] visited = new boolean[n];
        dfs(k - 1, visited, graph,memo, 0);
        int res = Integer.MIN_VALUE;
        for (int time : memo) {
            res = Math.max(time,res);
        }
        return check(visited) ? res : -1;
    }

    private void dfs(int nodeNum, boolean[] visited, int[][] graph,int[] memo, int t) {
        if (t >= memo[nodeNum])
            return;
        memo[nodeNum] = t;
        visited[nodeNum] = true;
        for (int i = 0; i < graph[0].length; ++i) {
            if (graph[nodeNum][i] > -1)
                dfs(i, visited, graph, memo,t + graph[nodeNum][i]);
        }
    }

    private boolean check(boolean[] visited) {
        for (boolean b : visited) {
            if (b == false)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);
        System.out.println(res);
        res = sol.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1);
        System.out.println(res);
        res = sol.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2);
        System.out.println(res);
        res = sol.networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2);
        System.out.println(res);
    }
}
