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