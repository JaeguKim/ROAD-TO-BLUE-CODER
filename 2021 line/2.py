def solution(ball, order):
    ans = []
    que = []
    curBallNum = ball.copy()
    for order_num in order:
        isFind = True
        #print(curBallNum)
        while isFind:
            isFind = False
            for i,ball_num in enumerate(que):
                if curBallNum[0] == ball_num:
                    ans.append(ball_num)
                    que.pop(i)
                    curBallNum.pop(0)
                    isFind = True
                    break
                elif curBallNum[-1] == ball_num:
                    ans.append(ball_num)
                    que.pop(i)
                    curBallNum.pop(-1)
                    isFind = True
                    break
        if curBallNum[0] == order_num:
            ans.append(order_num)
            curBallNum.pop(0)
        elif curBallNum[-1] == order_num:
            ans.append(order_num)
            curBallNum.pop(-1)
        else:
            que.append(order_num)
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1])
        print(res)

tcs = [[[11, 2, 9, 13, 24], [9, 2, 13, 24, 11]]]
test(tcs)