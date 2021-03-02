# I missed aplying modular calculation when adding hash
class Solution:
    def match(self,s,n,size,ans,roll,p):
        m = {}
        hash = 0
        for i in range(size):
            hash = hash%p + (roll[size-i-1]*(ord(s[i])-ord('a')))%p 
            #hash = (hash*26+(ord(s[i])-ord('a')))%p
        m[hash] = [0]
        for j in range(size,n):
            hash = ((hash-roll[size-1]*(ord(s[j-size])-ord('a')))%p + p)%p
            hash = (hash*26 + (ord(s[j])-ord('a')))%p
            #keys = list(m.keys()) -> time wasting
            if hash in m:
                for start in m[hash]:
                    temp = s[start:start+size if start+size < n else n]
                    cur = s[j-size+1:j+1 if j+1 < n else n]
                    if temp == cur:
                        ans[0] = temp
                        return True
            if hash not in m:
                m[hash] = [j-size+1]
            else:
                m[hash].append(j-size+1)
        return False


    def longestDupSubstring(self, S: str) -> str:
        n = len(S)
        p = 10000007
        roll = []
        if n == 0:
            return ""
        roll.append(1)
        for i in range(1,n):
            roll.append((26*roll[i-1])%p)
        low = 1; high = n; mid = 0
        ans = ''; temp = [0]
        while low <= high:
            temp = [0]
            mid = low+(high-low)//2
            isMatched = self.match(S,n,mid,temp,roll,p)
            if isMatched:
                if len(temp[0]) > len(ans):
                    ans = temp[0]
                low = mid+1
            else:
                high = mid-1
        return ans