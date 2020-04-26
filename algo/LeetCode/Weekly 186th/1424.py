def findDiagonalOrder(nums):
    output = []
    maxWidth = -1
    maxHeight = len(nums)
    for list in nums:
        maxWidth = max(maxWidth,len(list))
    for list in nums:
        if len(list) < maxWidth:
            for i in range(maxWidth - len(list)):
                list.append(0)
    if maxHeight == 1:
        for elem in nums[0]:
            output.append(elem)
        return output
    for i in range(maxHeight*3):
        if i < maxHeight:
            startRow = i
            startCol = 0
            for j in range(i+1):
                if startRow > maxHeight-1 or startCol > maxWidth-1:
                    break
                if nums[startRow][startCol] != 0:
                    output.append(nums[startRow][startCol])
                startRow -= 1
                startCol += 1
        else:
            startRow = maxHeight-1
            startCol = i - maxHeight + 1
            print(startRow)
            print(startCol)
            while not(startRow > maxHeight-1 or startCol > maxWidth-1):
                if nums[startRow][startCol] != 0:
                    output.append(nums[startRow][startCol])
                startRow -= 1
                startCol += 1
              
    return output


#print(findDiagonalOrder([[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]))
#print(findDiagonalOrder([[1,2,3],[4],[5,6,7],[8],[9,10,11]]))
print(findDiagonalOrder([[3,3,18],[4,15,11],[19,11,14,14,3]]))