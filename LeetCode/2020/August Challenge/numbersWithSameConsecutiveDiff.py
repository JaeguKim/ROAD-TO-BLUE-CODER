class Solution:
    
    def helper(self,num,numStr):
        if num < 0 or num > 9:
            return
        else:
            numStr += str(num)
        if len(numStr) == self.N:
            self.res.append(int(numStr))
            return
        self.helper(num+self.K,numStr)
        if self.K != 0:
            self.helper(num-self.K,numStr)
        
    def numsSameConsecDiff(self, N: int, K: int) -> List[int]:
        self.N = N; self.K = K
        self.res = []
        if N == 1:
            self.helper(0,'')
        for i in range(1,10):
            self.helper(i,'')
        return self.res