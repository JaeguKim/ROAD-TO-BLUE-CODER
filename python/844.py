class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        # l1 = self.make_list(s)
        # l2 = self.make_list(t)
        # return ''.join(l1) == ''.join(l2)
        return self.two_ptr_sol(s,t)


    def make_list(self, s: str):
        new_list = []
        for ch in s:
            if ch == '#':
                if len(new_list) > 0:
                    new_list.pop()
            else:
                new_list.append(ch)
        return new_list


    def two_ptr_sol(self, s: str, t: str) -> bool:
        i = len(s)-1
        j = len(t)-1
        skipS = 0
        skipT = 0
        while i >= 0 or j >= 0:
            while i >= 0:
                if s[i] == '#':
                    i -= 1
                    skipS += 1
                elif skipS > 0:
                    skipS -= 1
                    i -= 1
                else:
                    break
            while j >= 0:
                if t[j] == '#':
                    skipT += 1
                    j -= 1
                elif skipT > 0:
                    skipT -= 1
                    j -= 1
                else:
                    break

            if i >= 0 and j >= 0 and s[i] != t[j]:
                return False
            if (i >= 0) != (j >= 0):
                return False
            i -= 1
            j -= 1
        return True






if __name__ == '__main__':
    print(Solution().backspaceCompare('ab#c','ad#c'))
    print(Solution().backspaceCompare('ab##', 'c#d#'))
    print(Solution().backspaceCompare('a#c', 'b'))