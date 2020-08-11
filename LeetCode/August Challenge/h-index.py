class Solution:
    def hIndex(self, citations: List[int]) -> int:
        sortedlist = sorted(citations)
        l = 0; r = len(citations)-1; n = len(citations)
        while l<=r:
            mid = (l+r)//2
            if sortedlist[mid] == n-mid:
                return sortedlist[mid]
            elif sortedlist[mid] > n-mid:
                r = mid-1
            else:
                l = mid+1
        return n-l