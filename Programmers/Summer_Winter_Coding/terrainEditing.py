from collections import defaultdict
class Solution:
    def getCost(self,h):
        cost = 0
        costHash = defaultdict(int)
        for row in self.land:
            for elem in row:
                if costHash[elem] == 0:
                    diff = h-elem
                    if diff > 0:
                        costHash[elem]+=self.P*diff
                    else:
                        costHash[elem]+=self.Q*abs(diff)
                cost += costHash[elem]
        return cost

    def solution(self,land, P, Q):
        self.land = land
        self.P = P
        self.Q = Q
        maxHeight = -1
        minHeight = -1
        ans = -1
        for row in land:
            maxHeight = max(row) if maxHeight == -1 else max(max(row),maxHeight)
            minHeight = min(row) if minHeight == -1 else min(min(row),minHeight)
        left = minHeight; right = maxHeight;
        #print('minHeight : {}, maxHeight : {}'.format(minHeight,maxHeight))
        ans = 0
        while left <= right:
            middle = (left+right)//2
            if left == right:
                ans = self.getCost(middle)
                break
            cost1 = self.getCost(middle); cost2 = self.getCost(middle+1)
            if cost1 < cost2:
                right = middle
            elif cost1 > cost2:
                left = middle+1
            else:
                ans = cost1
                break
        return ans

def solution(land, P, Q):
    return Solution().solution(land,P,Q)

tcs = [[[[1,2],[2,3]],3,2],
    [[[4,4,3],[3,2,2],[2,1,0]],5,3],
]
def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1],tc[2])
        print(res)
test(tcs)