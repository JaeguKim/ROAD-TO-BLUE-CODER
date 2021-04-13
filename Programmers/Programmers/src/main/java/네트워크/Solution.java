package 네트워크;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private boolean[] visited;
    int n;
    private int[][] computers;

    public void bfs(int node) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(node);
        while (q.size() > 0) {
            int p = q.poll();
            visited[p] = true;
            for (int i=0;i<n;i++) {
                if (computers[p][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        int ans = 0;
        for (int i=0;i<n;i++) {
            if (visited[i] == false) {
                bfs(i);
                ans++;
            }
        }
        return ans;
    }
}
