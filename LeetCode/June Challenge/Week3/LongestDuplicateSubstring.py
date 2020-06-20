from typing import List,Dict
class Solution:
    def match(self,s,n,size,ans,roll,p):
        m = {}
        hash = 0
        for i in range(n):
            hash = (hash*26 + (ord(s[i])-ord('a')))%p
        #print(hash)
        m[hash] = [0]
        for j in range(size,n):
            hash = ((hash-roll[size-1]*(ord(s[j-size])-ord('a')))%p + p)%p
            hash = (hash*26 + (ord(s[j])-ord('a')))%p
            keys = list(m.keys())
            if hash != keys[-1] and hash in m:
                for start in m[hash]:
                    temp = s[start:start+size if start+size<=n else n]
                    curr = s[j-size+1:j+1]
                    if temp == curr:
                        ans = temp
                        return True
            if hash not in m:
                m[hash] = [j-size+1]
            else:
                m[hash].append(j-size+1)
        return False


    def longestDupSubstring(self, S: str) -> str:
        p = 10000007
        roll = []
        n = len(S)
        if n == 0:
            return ""
        roll.append(1)
        for i in range(1,n):
            roll.append((26*roll[i-1])%p)
        #print(roll)
        low = 1; high = n; mid = 0
        ans = ''; temp = ''
        while low <= high:
            temp = ''
            mid = low+(high-low)//2
            isMatched = self.match(S,n,mid,temp,roll,p)
            if isMatched:
                if len(temp) > len(ans):
                    ans = temp
                low = mid+1
            else:
                high = mid-1
        return ans

def test(testCase):
    sol = Solution()
    for case in testCase:
        print(case)
        print(sol.longestDupSubstring(case))

sol = Solution()
testCase = ["banana","abcd"]
test(testCase)
