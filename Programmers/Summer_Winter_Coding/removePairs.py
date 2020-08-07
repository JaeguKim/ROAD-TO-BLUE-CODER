def solution(s):
    answer = 0
    myStack = []
    for ch in s:
        if len(myStack) > 0:
            top = myStack[-1]
            if top == ch:
                myStack.pop(-1)
            else:
                myStack.append(ch)
        else:
            myStack.append(ch)
    answer = 1 if len(myStack) == 0 else 0
    return answer

def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)

tcs = [
    'baabaa',
    'cdcd'
]
test(tcs)