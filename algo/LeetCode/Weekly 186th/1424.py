def findDiagonalOrder(nums):
    diagonals = {}
    for i, line in enumerate(nums):
        for j in range(len(line)):
            if i+j not in diagonals.keys():
                diagonals[i+j] = []
            diagonals[i+j].append(line[j])
    ret = []
    for i in range(len(diagonals)):
        ret.extend(diagonals[i][::-1])
    return ret

# def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
#         # we create a dic indexed by sum i+j, as all items in a diagonal will have the same sum.
#         diagonals = collections.defaultdict(list)
        
#         # traverse from top row to bottom; we can see this is reversed order compared to our desired result.
#         for i, line in enumerate(nums):
#             for j in range(len(line)):
#                 diagonals[i+j].append(line[j]) # add the element to the correct bucket.
#         i = 0
#         ret = []
        
#         # we now reverse the buckets and concatenate them to get the result.
#         while i in diagonals:
#             ret.extend(diagonals[i][::-1])
#             i += 1
#         return ret

#print(findDiagonalOrder([[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]))
#print(findDiagonalOrder([[1,2,3],[4],[5,6,7],[8],[9,10,11]]))
#print(findDiagonalOrder([[3,3,18],[4,15,11],[19,11,14,14,3]]))
print(findDiagonalOrder([[1],[2],[3]]))