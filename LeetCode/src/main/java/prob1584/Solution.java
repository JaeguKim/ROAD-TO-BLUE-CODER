package prob1584;

import java.util.*;

public class Solution {

    private class Node implements Comparable<Node> {
        public int s,e,w;
        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(w,o.w);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        for (int i=0; i<points.length; ++i) {
            for (int j=i+1; j<points.length; ++j) {
                pq.add(new Node(i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }
        int res = 0;
        List<Node> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (visited.contains(n.s) && visited.contains(n.e))
                continue;
            visited.add(n.s);
            visited.add(n.e);
            res += n.w;
            list.add(n);
        }
        if (list.size() != points.length-1) {
            
        }
        return res;
    }
}
