# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverseTree(self,node,binary):
        binary += str(node.val)
        if node.left == None and node.right == None:
            self.sum += int(binary,2)
            return
        if node.left != None:
            self.traverseTree(node.left,binary)
        if node.right != None:
            self.traverseTree(node.right,binary)
            
    def sumRootToLeaf(self, root: TreeNode) -> int:
        self.sum = 0
        if root != None:
            self.traverseTree(root,'')
        return self.sum