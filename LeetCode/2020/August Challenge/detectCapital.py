class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        isCapital = True if word[0].isupper() else False
        if isCapital:
            for i in range(2,len(word)):
                if not((word[i].islower() and word[i-1].islower()) or (word[i].isupper() and word[i-1].isupper())):
                    return False
        else:
            for i in range(1,len(word)):
                if word[i].isupper():
                    return False
        return True

