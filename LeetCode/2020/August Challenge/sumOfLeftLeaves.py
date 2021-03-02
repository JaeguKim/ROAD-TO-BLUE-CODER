# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self,parent,isLeft):
        if parent.left == None and parent.right == None:
            if isLeft:
                self.ans += parent.val
            return
        if parent.left != None:
            self.helper(parent.left,True)
        if parent.right != None:
            self.helper(parent.right,False)
                
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if root == None:
            return 0
        self.ans = 0
        self.helper(root,False)
        return self.ans