class WordDictionary:

    def __init__(self):
        self.myDict = {}

    def addWord(self, word: str) -> None:
        parent = self.myDict
        N = len(word)
        for i in range(N):
            ch = word[i]
            if ch not in parent:
                parent[ch] = {}
                if i == N-1:
                    parent[ch]['!'] = '*' 
            parent = parent[ch]
        #print(self.myDict)
        
    def recur(self,parent,word):
        if len(word) == 1:
            if word == '.':
                for key in parent:
                    # parent[key]에 '!'가 존재하면 True 아니면 False
                    if '!' in parent[key]:
                        return True
                return False
            else:
                # parent에 word가 있고 해당 '!' 가 parent[word] 에 존재하면 True
                return True if word in parent and '!' in parent[word] else False
        ch = word[0]
        newWord = word[1:]
        if ch == '.':
            for key in parent:
                if key != '!' and self.recur(parent[key],newWord):
                    return True
            return False
                
        if ch in parent:
            newParent = parent[ch]
            if self.recur(newParent,newWord):
                return True
        return False

    def search(self, word: str) -> bool:
        return self.recur(self.myDict,word)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)