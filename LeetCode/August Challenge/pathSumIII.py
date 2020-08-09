# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#경우를 두가지로 나누어서 깔끔한 풀이
from collections import defaultdict
class Solution:
    def getNumOfPath(self,root,accumSum):
        if root == None:
            return 0
        res = 0
        accumSum += root.val
        #print('{},accumSum : {}, sum : {}'.format(root.val,accumSum,self.sum))
        if accumSum == self.sum:
           # print('find!')
            res+=1
        res+=self.getNumOfPath(root.left,accumSum)
        res+=self.getNumOfPath(root.right,accumSum)
        return res
    
    def pathSum(self, root: TreeNode, sum: int) -> int:
        if root == None:
            return 0
        self.sum = sum
        return self.pathSum(root.left,sum)+self.getNumOfPath(root,0)+self.pathSum(root.right,sum)
        