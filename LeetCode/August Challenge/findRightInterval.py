#Two Pointer Approach
class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        interval_starts = sorted([(val[0], index) for index, val in enumerate(intervals)])
        interval_ends = sorted([(val[1], index) for index, val in enumerate(intervals)])
        ans = [-1] * len(intervals)
        s_index, e_index = 0, 0
        while s_index < len(interval_ends) and e_index < len(interval_ends):
            if interval_starts[s_index][1] == interval_ends[e_index][1]:
                s_index += 1
            elif interval_starts[s_index][0] < interval_ends[e_index][0]:
                s_index += 1
            else:
                ans[interval_ends[e_index][1]] = interval_starts[s_index][1]
                e_index += 1
        return ans

        