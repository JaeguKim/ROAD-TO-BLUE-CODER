class Solution:
    def toGoatLatin(self, S: str) -> str:
        words = S.split()
        res = ''
        vowels = ['a','e','i','o','u']
        for i in range(len(words)):
            firstCh = words[i][0]
            conv = ''
            if firstCh.lower() in vowels:
                conv = words[i]+'ma'
            else:
                conv = words[i][1:]+firstCh+'ma'
            conv+=''.join(['a']*(i+1))
            if i == len(words)-1:
                res+=conv
            else:
                res+=(conv+' ')
        return res