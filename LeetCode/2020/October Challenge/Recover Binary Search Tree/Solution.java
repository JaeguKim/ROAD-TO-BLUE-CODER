import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
}

// Time : O(NlogN), Space : O(N)
class Solution {

    private List<TreeNode> inorderList;
    void inorder(TreeNode root){
        if (root == null) return;
        inorderList.add(root.left);
        inorder(root);
        inorderList.add(root.right);
    }

    public void makeOriginal(TreeNode root, int n1, int n2){
        if (root == null) return;
        makeOriginal(root.left, n1, n2);
        if (root.val == n1) root.val = n2;
        else if (root.val == n2) root.val = n1;
        makeOriginal(root.right, n1, n2);
    }

    public void recoverTree(TreeNode root) {
        inorderList = new ArrayList<>();
        inorder(root);
        List<TreeNode> sortedList = new ArrayList<>(inorderList);
        sortedList.sort(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode n1, TreeNode n2) {
                return n1.val - n2.val;
            }
        });
        int num1 = 0;
        int num2 = 0;
        for (int i=0; i<inorderList.size(); i++){
            if (inorderList.get(i).val != sortedList.get(i).val){
                num1 = inorderList.get(i).val;
                num2 = sortedList.get(i).val;
            }
        }
        makeOriginal(root, num1, num2);
    }
}
