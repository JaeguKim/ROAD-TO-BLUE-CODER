from collections import defaultdict
class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        startDict = defaultdict(int)
        endDict = defaultdict(int)
        for trip in trips:
            startDict[trip[1]] += trip[0]
            endDict[trip[2]] += trip[0]
        
        cap = 0
        for i in range(0,1001):
            cap += startDict[i]
            cap -= endDict[i]
            if cap > capacity:
                return False
        return True
        