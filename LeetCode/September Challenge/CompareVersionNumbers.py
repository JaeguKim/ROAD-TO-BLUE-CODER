class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1Digits = []; v2Digits = []
        
        v1Digits = [int(ch,10) for ch in version1.split('.')]
        while len(v1Digits) > 0 and v1Digits[-1] == 0: v1Digits.pop(-1)
            
        v2Digits = [int(ch,10) for ch in version2.split('.')]
        while len(v2Digits) > 0 and v2Digits[-1] == 0: v2Digits.pop(-1)
            
        idx1=0;idx2=0;
        while idx1 < len(v1Digits) and idx2 < len(v2Digits):
            diff = v1Digits[idx1]-v2Digits[idx2]
            if diff < 0:
                return -1
            elif diff > 0:
                return 1
            idx1+=1;idx2+=1
        diff =  len(v1Digits) - len(v2Digits)
        if diff > 0:
            return 1
        elif diff == 0:
            return 0
        else:
            return -1
            