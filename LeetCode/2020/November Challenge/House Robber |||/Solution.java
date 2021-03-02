
public class Solution {

    int[] findMax(TreeNode node) {
        if (node == null) {
            return new int[]{0,0};
        }
        int[] leftMax = findMax(node.left);
        int[] rightMax = findMax(node.right);
        int case1 = leftMax[1] + rightMax[1] + node.val;
        int case2 = Math.max(leftMax[0],leftMax[1]) + Math.max(rightMax[0],rightMax[1]);
        return new int[]{case1,case2};
    }


    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = findMax(root);
        return Math.max(res[0],res[1]);
    }
}
