package 가장먼노드;

import java.util.*;

public class Solution {
    int[] dist;
    List<List<Integer>> adj;
    int n;

    public void runDijkstra() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        while (pq.size() > 0) {
            int node = pq.poll();
            for (int ne : adj.get(node)) {
                int newDist = dist[node] + 1;
                if (dist[ne] > newDist) {
                    dist[ne] = newDist;
                    pq.offer(ne);
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        dist = new int[n+1];
        adj = new ArrayList<>();
        this.n = n;
        Arrays.fill(dist,Integer.MAX_VALUE);
        for (int i=0;i<=n;++i) adj.add(new ArrayList<>());
        dist[1] = 0;

        for (int i=0;i<edge.length;i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        runDijkstra();
        int max = -1;
        for (int i=1;i<=n;i++) {
            if (max < dist[i] && dist[i] != Integer.MAX_VALUE) max = dist[i];
        }
        int ans=0;
        for (int i=1;i<=n;i++) {
            if (max == dist[i]) ans++;
        }
        return ans;
    }
}
