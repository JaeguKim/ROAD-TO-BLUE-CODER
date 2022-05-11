class Solution:
    def countVowelStrings(self, n: int) -> int:
        arr = [1 for i in range(5)]
        for i in range(1,n):
            for i in range(1,5):
                arr[i] += arr[i-1]
        return sum(arr)


if __name__ == '__main__':
    sol = Solution()
    print(sol.countVowelStrings(1))
    print(sol.countVowelStrings(2))
    print(sol.countVowelStrings(33))



