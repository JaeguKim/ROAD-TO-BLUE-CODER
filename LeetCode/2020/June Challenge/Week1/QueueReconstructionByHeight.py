#풀이까지 완벽하게 생각해냈지만, sorting하는 과정에서 실수를 하였다.
#검증을 할때 정확하게 내 풀이를 검증해서, 내 풀이를 틀린풀이라고 생각하지 말도록 주의해야겠다.
def solve(people):
    pairs = sorted(pairs,key=lambda x:(-x[0],x[1]))
    print(pairs)
    n = len(people)
    res = []
    for i in range(n):
        res.insert(pairs[i][1],pairs[i])
    return res

res = solve([[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]])