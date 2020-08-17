class Solution:
    def getSum(self,k):
        return k*(k+1)//2

    def getSum2(self,n,a,l):
        return n*(a+l)//2

    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        k = 1
        N = num_people
        res = [0]*N
        isFind = False
        prevSum = self.getSum(k)
        curSum = self.getSum(k+1)
        while (isFind == False):
            if prevSum <= candies < curSum:
                isFind = True
                k-=1
            else:
                k+=1
                prevSum = curSum
                curSum = self.getSum(k)
        print('k : {}'.format(k))
        print('prevSum : {}'.format(prevSum))
        lastRow = 0; lastCol = 0
        if candies == prevSum:
            lastRow = (k-1)//N; lastCol = k%N - 1
        else:
            lastRow = k//N; lastCol = k%N
        print('lastRow: {}'.format(lastRow))
        print('lastCol: {}'.format(lastCol))
        for i in range(N):
            if i < lastCol:
                res[i]=self.getSum2(lastRow+1,i+1,lastRow*N+i+1)
            else:
                res[i]=self.getSum2(lastRow,i+1,(lastRow-1)*N+i+1)
                if i == lastCol:
                    res[i]+=candies-prevSum if candies-prevSum > 0 else k
        print(res)
        return res