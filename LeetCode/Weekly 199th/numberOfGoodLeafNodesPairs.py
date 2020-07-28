from collections import defaultdict
class Solution:
    def findDistance(self,n1, n2): 
        trail1 = self.trails[n1]; trail2 = self.trails[n2]
        len1 = len(trail1); len2 = len(trail2)
        for i in range(min(len1,len2)):
           if trail1[i] != trail2[i]:
               return len1-i+len2-i
        return 0

    def findLeafNodes(self,node,trail):
        trail.append(node)
        left = node.left; right = node.right
        if left == None and right == None:
            self.leaves.append(node)
            self.trails[node] = trail
        if left != None:
            self.findLeafNodes(left,trail.copy())
        if right != None:
            self.findLeafNodes(right,trail.copy())

    def countPairs(self, root: TreeNode, distance: int) -> int:
        self.root = root
        self.leaves = []
        self.trails = defaultdict(list)
        self.findLeafNodes(root,[])
        sz = len(self.leaves)
        ans = 0
        print(self.leaves)
        for i in range(sz):
            for j in range(i+1,sz):
                if self.findDistance(self.leaves[i],self.leaves[j]) <= distance:
                    ans+=1
        return ans