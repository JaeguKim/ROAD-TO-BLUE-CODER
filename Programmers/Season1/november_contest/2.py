class Solution:
    def toStr(self,n,base):
        convertString = "0123456789ABCDEF"
        if n < base:
            return convertString[n]
        else:
            return self.toStr(n//base,base) + convertString[n%base]
    
    def convert(self,s):
        oneCnt = 0
        for ch in s:
            if ch == '1':
                oneCnt+=1
            else:
                self.zeroCnt += 1
        return self.toStr(oneCnt,2)
                        
    def solution(self,s):
        self.zeroCnt = 0
        cntOfConvert = 0
        while s != '1':
            s = self.convert(s)
            cntOfConvert += 1
        return [cntOfConvert,self.zeroCnt]
        

def solution(s):
    return Solution().solution(s)