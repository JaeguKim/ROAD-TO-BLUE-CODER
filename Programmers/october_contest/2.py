# 2^n 일때 n번 압축하면됨
# 현재 쿼드에 같은 원소로만 이루어져 있으면 같은수로 대체하고 리턴
# 같은 원소가 아니면 4등분으로 나눠서 결과값들을 더해서 리턴
# 아니면 그 부분을 4부분으로 나눠서 재귀적으로 실행
class Solution:

    def helper(self,arr):
        if self.isSame(arr):
            self.res[arr[0][0]] += 1
            return
        n = len(arr)
        leftUp = []
        for i in range(0,n//2):
            row = []
            for j in range(0,n//2):
                row.append(arr[i][j])
            leftUp.append(row)
        self.helper(leftUp)
        rightUp = []
        for i in range(0,n//2):
            row = []
            for j in range(n//2,n):
                row.append(arr[i][j])
            rightUp.append(row)
        self.helper(rightUp)
        leftDown = []
        for i in range(n//2,n):
            row = []
            for j in range(0,n//2):
                row.append(arr[i][j])
            leftDown.append(row)
        self.helper(leftDown)
        rightDown = []
        for i in range(n//2,n):
            row = []
            for j in range(n//2,n):
                row.append(arr[i][j])
            rightDown.append(row)
        self.helper(rightDown)
        
    def isSame(self,arr):
        prev = -1
        for i in range(len(arr)):
            for j in range(len(arr)):
                if prev == -1:
                    prev = arr[i][j]
                elif prev != arr[i][j]:
                    return False
        return True

    def solve(self,arr):
        self.res = [0,0]
        self.helper(arr)
        return self.res
    
def solution(arr):
    return Solution().solve(arr)

test = [[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]
res = solution(test)
print(res)