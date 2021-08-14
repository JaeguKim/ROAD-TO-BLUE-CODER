from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        first_row_contains_zero = False
        H = len(matrix)
        W = len(matrix[0])
        for i in range(0, W):
            if matrix[0][i] == 0:
                first_row_contains_zero = True
                break
        for i in range(1, H):
            for j in range(0, W):
                if matrix[i][j] == 0:
                    matrix[0][j] = 0
        for i in range(1, H):
            contains_zero = False
            for j in range(0, W):
                if matrix[i][j] == 0:
                    contains_zero = True
                    break
            for j in range(0, W):
                if matrix[0][j] == 0 or contains_zero:
                    matrix[i][j] = 0
        for i in range(0, W):
            if first_row_contains_zero:
                matrix[0][i] = 0
