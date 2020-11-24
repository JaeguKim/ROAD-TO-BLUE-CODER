from collections import Counter
#정답이 되는 수열의 길이는 2,4,6,...
#집합들간에 교집합의 원소의 갯수는 1개이상
#집합안에 원소들은 서로 다르다
import unittest

class TestStringMethods(unittest.TestCase):

    def testSolution(self):
        self.assertEqual(solution([0]),0)
        self.assertEqual(solution([5,2,3,3,5,3]),4)
        self.assertEqual(solution([0,3,3,0,7,2,0,2,2,0]),8)

def solution(a):
    cDict = Counter(a)
    maxCnt = -1
    for k in cDict:
        if cDict[k] <= maxCnt:
            continue
        i=0
        cnt=0
        while i < len(a)-1:
            if (a[i] != k and a[i+1] != k) or a[i]==a[i+1]:
                i+=1
                continue
            cnt+=1
            i+=2
        maxCnt = max(maxCnt,cnt)
    if maxCnt == -1:
        return 0
    return maxCnt*2

if __name__ == '__main__':
    unittest.main()
