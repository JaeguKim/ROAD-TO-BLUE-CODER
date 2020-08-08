# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import defaultdict
class Solution:
    def getNumOfPath(self,root,accumSum,parent):
        if root.left == None and root.right == None:
            if root.val+accumSum == self.sum:
                self.dict[(parent,root,accumSum)] = 1
               # print('leaf node - parent val : {}, node val : {}, accumSum : {}'.format(parent.val if parent!= None else "None",root.val,accumSum))
                return 1
            else:
                return 0
        accumSum += root.val
        leftNewSum = 0
        rightNewSum = 0
        if self.dict[(root.left)] == 0:
            self.dict[(root.left)] = 1
            leftNewSum += self.getNumOfPath(root.left,0,None) if root.left != None else 0
        if self.dict[(root.right)] == 0:
            self.dict[(root.right)] = 1
            rightNewSum += self.getNumOfPath(root.right,0,None) if root.right != None else 0
        leftAccumSum = self.getNumOfPath(root.left,accumSum,root) if root.left != None else 0
        rightAccumSum = self.getNumOfPath(root.right,accumSum,root) if root.right != None else 0
        if accumSum == self.sum:
            #print('parent val : {}, node val : {}, accumSum : {}'.format(parent.val if parent != None else "None",root.val,accumSum))
            return 1+leftNewSum+rightNewSum+leftAccumSum+rightAccumSum
        return leftNewSum+rightNewSum+leftAccumSum+rightAccumSum
    
    def pathSum(self, root: TreeNode, sum: int) -> int:
        if root == None:
            return 0
        self.sum = sum
        self.dict = defaultdict(int)
        return self.getNumOfPath(root,0,None)
        