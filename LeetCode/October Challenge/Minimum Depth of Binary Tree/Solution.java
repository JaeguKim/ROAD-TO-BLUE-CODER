class Solution {

    public int dfs(TreeNode node,int depth){
        if (node.left == null && node.right == null){
            return depth;
        }
        else if (node.left != null && node.right != null){
            return Math.min(dfs(node.left,depth+1),dfs(node.right,depth+1));
        }
        if (node.left != null){
            return dfs(node.left,depth+1);
        }
        else {
            return dfs(node.right,depth+1);
        }
        
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root,1);
    }
}