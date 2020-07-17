#TIME : 35min
def getPos(num):
    r = 0
    c = 0
    if num >= 1 and num <= 9:
        r = 2 if num == 7 else num//4
        mod = num%3
        if mod == 1 or mod == 2:
            c = num%3 - 1
        else:
            col = 2
    else:
        r = 3; c =1
    return [r,c]

def dist(pos1,pos2):
    return abs(pos1[0]-pos2[0])+abs(pos1[1]-pos2[1])

def solution(numbers, hand):
    leftPads = [1,4,7]
    rightPads = [3,6,9]
    ans = ''
    dominant = "L" if hand == "left" else "R"
    lPos = [3,0]; rPos = [3,2]

    for num in numbers:
        numPos = getPos(num)
        if num in leftPads:
            ans+='L'
            lPos = getPos(num)
        elif num in rightPads:
            ans+='R'
            rPos = getPos(num)
        else:
            lDist = dist(lPos,numPos); rDist = dist(rPos,numPos)
            if lDist > rDist:
                ans+='R'
                rPos = getPos(num)
            elif lDist < rDist:
                ans+='L'
                lPos = getPos(num)
            else:
                ans+=dominant
                if dominant == 'L': lPos = getPos(num)
                else: rPos = getPos(num)
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1])
        print(res)

tcs = [ [[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5],"right"],
        [[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2],"left"],
        [[1, 2, 3, 4, 5, 6, 7, 8, 9, 0],"right"]
]
test(tcs)