def solution(n, words):
    prevWords = []
    num = 0; turn = 0
    for i in range(len(words)):
        if words[i] in prevWords or len(words[i]) == 1 or (len(prevWords)>0 and words[i][0]!=prevWords[-1][-1]):
            num = i%n + 1
            turn = i//n + 1
            break
        prevWords.append(words[i])

    return [num,turn]

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1])
        print(res)

tcs = [
[2,["hello", "one", "even", "never", "now", "world", "draw"]]
]
test(tcs)    