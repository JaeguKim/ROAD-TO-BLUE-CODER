#문제를 여러번 잘못 이해해서 헛발질을 하였다.
#no more than 3 => 3은 포함X 
#1hour 14min
from typing import List
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        myList = []
        i = 1; j = 0;
        cnt = 0
        n = len(citations)
        while i<n+1:
            if j < n and citations[j] < i:
                cnt+=1
                j+=1
            else:
                myList.append(cnt)
                i+=1
        print(myList)
        for i in range(n-1,-1,-1):
            if n-myList[i] >= i+1:
                return i+1
        return 0

# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         l = 0; r = len(citations)-1; n = len(citations)
#         while l<=r:
#             mid = (l+r)//2
#             if citations[mid] == n-mid:
#                 return citations[mid]
#             elif citations[mid] > n-mid:
#                 r = mid-1
#             else:
#                 l = mid+1
#         return n-l

sol = Solution()
res = sol.hIndex([0,1,3,5,6])
res = sol.hIndex([0,1,3,3,6])
res = sol.hIndex([0,0,0,0,1])
res = sol.hIndex([])
res = sol.hIndex([0])
res = sol.hIndex([1,1])
