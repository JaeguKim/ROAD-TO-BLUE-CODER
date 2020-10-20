class Solution {

    public HashMap<Integer,Node> hashMap;

    public void Helper(Node original, Node copiedNode){
        hashMap.put(copiedNode.val,copiedNode);
        for (Node neighbor : original.neighbors){
            Node target = null;
            if (hashMap.containsKey(neighbor.val)) target = hashMap.get(neighbor.val);
            else target = new Node(neighbor.val); 
            copiedNode.neighbors.add(target);
            if (!hashMap.containsKey(neighbor.val))
                Helper(neighbor,target);
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        hashMap = new HashMap<>();
        Node newGraphParent = new Node(node.val);
        Helper(node,newGraphParent);
        return newGraphParent;
    }
}