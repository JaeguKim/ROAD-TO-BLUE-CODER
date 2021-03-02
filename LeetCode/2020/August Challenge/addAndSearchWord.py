class WordDictionary:

    def __init__(self):
        #self.myDict = {}
        self.children = [None]*26
        self.isEndOfWord = False

    def addWord(self, word: str) -> None:
        # parent = self.myDict
        # N = len(word)
        # for i in range(N):
        #     ch = word[i]
        #     if ch not in parent:
        #         parent[ch] = {}
        #         if i == N-1:
        #             parent[ch]['!'] = '*' 
        #     parent = parent[ch]
        curr = self
        for c in word:
            if curr.children[ord(c)-ord('a')] == None:
                curr.children[ord(c)-ord('a')] = WordDictionary()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEndOfWord = True

    def recur(self,parent,word):
        if len(word) == 1:
            if word == '.':
                for key in parent:
                    if '!' in parent[key]:
                        return True
                return False
            else:
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
        # return self.recur(self.myDict,word)
        curr = self
        for i in range(len(word)):
            c = word[i]
            if c == '.':
                for ch in curr.children:
                    if ch and ch.search(word[i+1:]):
                        return True
                return False
            if curr.children[ord(c)-ord('a')] == None:
                return False
            curr = curr.children[ord(c)-ord('a')]
        return curr and curr.isEndOfWord
# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)