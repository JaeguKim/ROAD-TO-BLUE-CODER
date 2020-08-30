#조급한 마음으로 코딩하면 디버깅하는데 오래걸림
#문제의 조건에 A is a permutation of the integers from 1 to A.length 가 있으므로
#소팅할필요는 없다
class Solution:
    def reverseList(self,A,idx):
        for i in range((idx+1)//2):
            temp = A[i]
            A[i] = A[idx-i]
            A[idx-i] = temp
            
    def pancakeSort(self, A: List[int]) -> List[int]:
        sortedA = sorted(A)
        N = len(A)
        ans = []
        for i in range(N-1,-1,-1):
            if A[i] == sortedA[i]:
                continue
            for j in range(N):
                if A[j] == sortedA[i]:
                    if i != j:
                        if j != 0:
                            self.reverseList(A,j)    
                            ans.append(j+1)
                        if A[i] != sortedA[i]:
                            self.reverseList(A,i)
                            ans.append(i+1)
                    break
        return ans
                    
#Improved
class Solution:
    def reverseList(self,A,idx):
        for i in range((idx+1)//2):
            temp = A[i]
            A[i] = A[idx-i]
            A[idx-i] = temp
            
    def pancakeSort(self, A: List[int]) -> List[int]:
        sortedA = sorted(A)
        N = len(A)
        ans = []
        for i in range(N,0,-1):
            for j in range(i):
                if A[j] == i:
                    if i == j+1:
                        break
                    if j != 0:
                        self.reverseList(A,j)
                        ans.append(j+1)
                    if A[i-1] != i:
                        self.reverseList(A,i-1)
                        ans.append(i)
                        break
        return ans