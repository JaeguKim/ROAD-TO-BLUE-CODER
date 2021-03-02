//TIME : O(N^2), SPACE : O(1)
// class Solution {
//     int maxDiff = Integer.MIN_VALUE;

//     public void updateMaxDiff(TreeNode root, TreeNode cur, int val){
//         if (root == null) return;
//         if (root != cur) {
//             maxDiff = Math.max(maxDiff,Math.abs(val-root.val));
//         }
//         updateMaxDiff(root,cur.left,val);
//         updateMaxDiff(root,cur.right,val);
//     }

//     public void traverseTree(TreeNode root){
//         if (root == null) return;
//         updateMaxDiff(root,root,root.val);
//         traverseTree(root.left);
//         traverseTree(root.right);
//     }

//     public int maxAncestorDiff(TreeNode root) {
//         traverseTree(root);
//         return maxDiff;
//     }
// }

// TIME : O(N), SPACE : O(1)
class Solution {

    int maxDiff = 0;

    public void traverseTree(TreeNode root, int minVal, int maxVal) {
        if (root == null) return;
        int diff1 = Math.abs(minVal-root.val);
        int diff2 = Math.abs(maxVal-root.val);
        int largerDiff = Math.max(diff1,diff2);
        maxDiff = Math.max(maxDiff,largerDiff);
        int newMinVal = Math.min(minVal,root.val);
        int newMaxVal = Math.max(maxVal,root.val);
        traverseTree(root.left,newMinVal,newMaxVal);
        traverseTree(root.right,newMinVal,newMaxVal);
    }

    public int maxAncestorDiff(TreeNode root) {
        traverseTree(root, root.val, root.val);
        return maxDiff;
    }
}