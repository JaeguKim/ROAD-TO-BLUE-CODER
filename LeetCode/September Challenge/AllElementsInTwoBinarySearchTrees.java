import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class AllElementsInTwoBinarySearchTrees {
     
    List<Integer> nums = new ArrayList();
    
    void inorder(TreeNode node){
        if (node == null)
            return;
        if (node != null){
            nums.add(node.val);
        }
        if (node.left != null){
            inorder(node.left);
        }
        if (node.right != null){
            inorder(node.right);
        }
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        nums.sort(null);
        return nums;
    }
}