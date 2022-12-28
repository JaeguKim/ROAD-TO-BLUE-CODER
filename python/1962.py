import heapq
import math
import unittest
from typing import List


class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        h = []
        for pile in piles:
            heapq.heappush(h, -pile)
        i = 0
        while i < k:
            root = -heapq.heappop(h)
            new_cnt = root-math.floor(root/2)
            heapq.heappush(h, -new_cnt)
            i += 1
        res_list = [-heapq.heappop(h) for i in range(len(h))]
        return sum(res_list)


class SolutionTest(unittest.TestCase):
    def test1(self):
        self.assertEqual(12, Solution().minStoneSum([5, 4, 9], 2))

    def test2(self):
        self.assertEqual(12, Solution().minStoneSum([4, 3, 6, 7], 3))

if __name__ == '__main__':
    unittest.main()