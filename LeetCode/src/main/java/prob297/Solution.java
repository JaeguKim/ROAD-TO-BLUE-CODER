package prob297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 1 2 ! ! 3 4 ! ! 5 ! !
public class Codec {

    StringBuilder sb = new StringBuilder();
    String splitStr = ",";
    String endStr = "!";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        buildString(root);
        return sb.toString();
    }

    // 1,2,!,!,3,4,!,!,5,!,!,
    private void buildString(TreeNode cur) {
        if (cur == null) {
            sb.append(endStr).append(splitStr);
        } else {
            sb.append(cur.val).append(splitStr);
            buildString(cur.left);
            buildString(cur.right);
        }
    }

    // 1,2,!,!,3,4,!,!,5,!,!,
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> que = new LinkedList<>();
        que.addAll(Arrays.asList(data.split(splitStr)));
        return buildTree(que);
    }

    public TreeNode buildTree(Queue<String> que) {
        String s = que.poll();
        if (s.equals(endStr)) return null;
        TreeNode treeNode = new TreeNode(Integer.parseInt(s));
        treeNode.left = buildTree(que);
        treeNode.right = buildTree(que);
        return treeNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));