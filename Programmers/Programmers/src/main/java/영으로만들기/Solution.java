package 영으로만들기;

import java.util.*;

class Solution {

    List<List<Integer>> graph;
    long[] a;
    boolean[] visited;
    long ans = 0;

    public void dfs(int p, int c) {
        if (visited[c]) return;
        List<Integer> adj = graph.get(c);
        visited[c] = true;
        for (int i=0;i<adj.size();i++) {
            dfs(c,adj.get(i));
        }
        if (p == -1) return;
        a[p] += a[c];
        ans += Math.abs(a[c]);
    }

    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        this.a = new long[n];
        for (int i=0;i<n;i++) this.a[i]=a[i];
        graph = new ArrayList<>();
        visited = new boolean[n];
        if (Arrays.stream(a).sum() != 0) return -1;
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(-1,0);
        return ans;
    }
}