class Solution:

    def solution(self,arr):
        ans = 1
        numOfOperand = len(arr)//2 + 1
        dpMax = []
        dpMin = []
        for i in range(200):
            dpMax.append([-1000000]*200)
            dpMin.append([1000000]*200)
        for i in range(numOfOperand):
            dpMax[i][i] = int(arr[i*2])
            dpMin[i][i] = int(arr[i*2])
        for calc in range(1,numOfOperand):
            for i in range(numOfOperand-calc):
                j = calc+i
                for k in range(i,j):
                    if arr[k*2+1] == "-":
                        dpMax[i][j] = max(dpMax[i][k]-dpMin[k+1][j],dpMax[i][j])
                        dpMin[i][j] = min(dpMin[i][k]-dpMax[k+1][j],dpMin[i][j])
                    elif arr[k*2+1] == "+":
                        dpMax[i][j] = max(dpMax[i][k]+dpMax[k+1][j],dpMax[i][j])
                        dpMin[i][j] = min(dpMin[i][k]+dpMin[k+1][j],dpMin[i][j])
        return dpMax[0][numOfOperand-1]

def solution(arr):
    res = Solution().solution(arr)
    return res

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = [['1', '-', '3', '+', '5', '-', '8'],
['5', '-', '3', '+', '1', '+', '2', '-', '4'],
]
test(tcs)