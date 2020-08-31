from collections import defaultdict

class Solution:

    def find(self,x):
        if self.parent[x] == -1:
            return x
        self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self,x,y):
        px = self.find(x); py = self.find(y)
        if px != py:
            self.parent[py] = px
        
    def largestComponentSize(self, A: List[int]) -> int:
        
        self.parent = [-1]*(100001)
            
        for num in A:
            for i in range(2,int(sqrt(num)+1)):
                if num % i == 0:
                    self.union(num,i)
                    self.union(num,num//i)
        
        cntDict = defaultdict(int)
        ans = 0
        for num in A:
            parentNode = self.find(num)
            cntDict[parentNode] += 1
            ans = max(ans,cntDict[parentNode])
        return ans