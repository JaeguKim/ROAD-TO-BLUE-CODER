from collections import defaultdict
class Solution:
    def getNodeInfoDict(self,root,x,y):
        self.nodeInfo[x].append([root.val,y])
        if root.left == None and root.right == None:
            return
        if root.left != None:
            self.getNodeInfoDict(root.left,x-1,y-1)
        if root.right != None:
            self.getNodeInfoDict(root.right,x+1,y-1)

    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        self.nodeInfo = defaultdict(list)
        self.getNodeInfoDict(root,0,0)
        print(self.nodeInfo)
        self.nodeInfo = sorted(self.nodeInfo.items())
        print(self.nodeInfo)
        res = []
        for item in self.nodeInfo:
            temp = []
            for val,y in sorted(item[1],key=lambda x : (-x[1],x[0])):
                temp.append(val)
            res.append(temp)
        return res