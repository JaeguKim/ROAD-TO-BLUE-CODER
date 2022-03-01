package prob662;

import java.util.*;

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

class TreeNode {
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

class Solution {

    private class MinMax {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    private void searchPreOrder(Map<Integer,MinMax> mp, TreeNode cur, int level, int idx) {
        if (cur == null) return;
        if (!mp.containsKey(level)) mp.put(level, new MinMax());
        MinMax mm = mp.get(level);
        mm.min = Math.min(mm.min,idx);
        mm.max = Math.max(mm.max,idx);
        searchPreOrder(mp,cur.left,level+1,idx*2-mm.min);
        searchPreOrder(mp,cur.right,level+1,idx*2+1-mm.min);
    }

    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer,MinMax> mp = new HashMap<>();
        searchPreOrder(mp,root,0,0);
        int ans = Integer.MIN_VALUE;
        for (int key : mp.keySet()) {
            ans = Math.max(ans,mp.get(key).max-mp.get(key).min+1);
        }
        return ans;
    }

    private class TreeNodeWrapper {
        TreeNode node;
        int idx;
        public TreeNodeWrapper(TreeNode node, int idx) {
            this. node = node;
            this.idx = idx;
        }
    }

    public int bfs_widthOfBinaryTree(TreeNode root) {
        Deque<TreeNodeWrapper> que = new ArrayDeque<>();
        que.add(new TreeNodeWrapper(root,0));
        int ans = 0;
        while (que.size() > 0) {
            ans = Math.max(ans,que.peekLast().idx-que.peekFirst().idx+1);
            int leftIdx = que.peekFirst().idx;
            int curQueSize = que.size();
            for (int i=0; i<curQueSize; ++i) {
                TreeNodeWrapper cur = que.pollFirst();
                if (cur.node.left != null) {
                    que.add(new TreeNodeWrapper(cur.node.left,cur.idx*2-leftIdx));
                }
                if (cur.node.right != null) {
                    que.add(new TreeNodeWrapper(cur.node.right,cur.idx*2+1-leftIdx));
                }
            }
        }
        return ans;
    }
}
