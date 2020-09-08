from collections import defaultdict

class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        words = str.split(' ')
        wordHash = defaultdict(int)
        patternHash = defaultdict(int)
        offset = 0
        resPattern = ''
        pattern_offset = 0
        newPattern = ''
        
        for ch in pattern:
            if patternHash[ch] == 0:
                patternHash[ch] = ord('a')+pattern_offset
                pattern_offset += 1
                newPattern += chr(patternHash[ch])
            else:
                newPattern += chr(patternHash[ch])
                
        for word in words:
            if wordHash[word] == 0:
                wordHash[word] = ord('a')+offset
                offset += 1
                resPattern += chr(wordHash[word])
            else:
                resPattern += chr(wordHash[word])
        
        return newPattern == resPattern
            