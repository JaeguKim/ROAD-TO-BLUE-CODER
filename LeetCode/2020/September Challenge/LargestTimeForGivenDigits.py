from collections import defaultdict

class Solution:
    def isValid(self,res):
        if int(res[0]) > 2:
            return False
        elif int(res[0]) == 2 and int(res[1]) > 3:
            return False
        elif int(res[2]) > 5:
            return False
        return True
 
    def helper(self,curIdxPool,res):        
        if len(res) == 4:
            if self.isValid(res):
                if self.ans == '':
                    self.ans = res
                    return
                for i in range(4):
                    if int(res[i]) > int(self.ans[i]):
                        self.ans = res
                        return
                    elif int(res[i]) < int(self.ans[i]):
                        return
            return
        for i in range(len(curIdxPool)):
            newIdx = curIdxPool[i]
            res += str(self.A[newIdx])
            newList = curIdxPool.copy()
            newList.pop(i)
            self.helper(newList,res)
            res = res[:-1]
            
    def largestTimeFromDigits(self, A: List[int]) -> str:
        self.A = A
        indexPool = []
        self.ans = ''
        for i in range(len(A)):
            indexPool.append(i)
        self.helper(indexPool,'')
        return '{}{}:{}{}'.format(self.ans[0],self.ans[1],self.ans[2],self.ans[3]) if self.ans != '' else ''
        