/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 각각 노드에 대해서 현재노드를 포함한 하위노드들의 합을 기록합니다
// 그리고 모든 노드에 대해서 왼쪽 노드와 오른쪽 노드의 차이를 전체정답에 더합니다
class Solution {

    int res = 0;

    public int getSum(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        res += Math.abs(leftSum-rightSum);
        return leftSum+rightSum+root.val;
    }

    public int findTilt(TreeNode root) {
        getSum(root);
        return res;
    }
}