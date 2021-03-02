# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if root == None: return root
    
        def inorder_predecessor(root):
            root = root.left
            while root.right != None: root = root.right
            return root.val
        
        def inorder_successor(root):
            root = root.right
            while root.left != None: root = root.left
            return root.val
        
        if key > root.val: root.right = self.deleteNode(root.right, key)
        elif key < root.val: root.left = self.deleteNode(root.left, key)
        else:
            if root.left == None and root.right == None: root = None
            elif root.left != None: # find inorder predecessor
                root.val = inorder_predecessor(root)
                root.left = self.deleteNode(root.left, root.val)
            else: # find inorder successor
                root.val = inorder_successor(root)
                root.right = self.deleteNode(root.right, root.val)
        return root