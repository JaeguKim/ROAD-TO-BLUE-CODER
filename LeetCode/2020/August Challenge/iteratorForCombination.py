class CombinationIterator:
    
    def getCombinations(self,resStr,curStr):
        if len(resStr) == self.combinationLength:
            self.combinations.append(resStr)
            return
        print('resStr : {}'.format(resStr))
        print('curStr : {}'.format(curStr))
        for i in range(len(curStr)):
            self.getCombinations(resStr+curStr[i],curStr[i+1:])
    
    def __init__(self, characters: str, combinationLength: int):
        self.idx = 0
        self.characters = characters
        self.combinationLength = combinationLength
        self.combinations = []
        self.getCombinations('',characters)
        self.N = len(self.combinations)
        print(self.combinations)
        
    def next(self) -> str:
        if self.hasNext():
            curItem = self.combinations[self.idx]
            self.idx += 1
            return curItem
        else:
            return ''

    def hasNext(self) -> bool:
        if self.idx < self.N:
            return True
        else:
            return False

# itertools.combinations 
# Logic 1: Using itertools to get all combinations - 100 pass 86% faster
class CombinationIterator:

    def __init__(self, characters: str, combinationLength: int):
        import itertools
        # return type of map() -> map object -> can be converted to list or set
        self.combinations = list(map("".join, itertools.combinations(characters, r=combinationLength)))

    def next(self) -> str:
        return self.combinations.pop(0)

    def hasNext(self) -> bool:
        if self.combinations:
            return True
        return False