# TIME : 30min
class Solution:
    def check(self,p1,p2):
        if p1 == None and p2 == None:
            return True
        val1 = p1.val if p1 != None else None
        val2 = p2.val if p2 != None else None
        if val1 != val2:
            return False
        if self.check(p1.left,p2.left) == False:
            return False
        if self.check(p1.right,p2.right) == False:
            return False
        return True

    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        return self.check(p,q)