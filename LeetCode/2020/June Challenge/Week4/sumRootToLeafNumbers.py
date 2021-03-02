#TIME : 16min
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def solve(self,root,num,res):
        if root.left == None and root.right == None:
            res[0] += int(num)
            return
        num += str(root.val)
        if root.left != None:
            self.solve(root.left,num,res)
        if root.right != None:
            self.solve(root.right,num,res)

    def sumNumbers(self, root: TreeNode) -> int:
        res = [0]
        self.solve(root,0,res)

