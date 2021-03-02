import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Map<Integer,List<Node>> map;

    public void dfs(Node root,int d){
        if (root == null) return;
        if (!map.containsKey(d)) map.put(d,new ArrayList<>());
        map.get(d).add(root);
        dfs(root.left,d+1);
        dfs(root.right,d+1);
        
    }

    public void populateNodes(List<Node> list){
        for (int i=0;i<list.size()-1;i++){
            list.get(i).next = list.get(i+1);
        }
    }

    public Node connect(Node root) {
        map = new HashMap<>();
        dfs(root,1);
        for (int i=1;i<=map.size();i++){
            populateNodes(map.get(i));
        }
        return root;
    }
}