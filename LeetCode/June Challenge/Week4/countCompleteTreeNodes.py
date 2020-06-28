#TIME : 6min
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: TreeNode) -> int:
        if root == None:
            return 0
        elif root.left == None and root.right == None:
            return 1
        leftCnt = self.countNodes(root.left)
        rightCnt = self.countNodes(root.right)
        return leftCnt + rightCnt + 1