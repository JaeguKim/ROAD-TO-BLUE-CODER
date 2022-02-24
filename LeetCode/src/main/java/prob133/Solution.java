package prob133;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer,Node> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        Node start = new Node(node.val);
        map.put(start.val, start);
        while (que.size() > 0) {
            Node cur = que.poll();
            Node copiedCur = map.get(cur.val);
            for (Node adjNode : cur.neighbors) {
                if (!map.containsKey(adjNode.val)) {
                    map.put(adjNode.val,new Node(adjNode.val));
                    que.add(adjNode);
                }
                copiedCur.neighbors.add(map.get(adjNode.val));
            }
        }
        return start;
    }
}
