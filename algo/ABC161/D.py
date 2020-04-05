from collections import deque

k = int(input())
lunlun = []
q = deque([1,2,3,4,5,6,7,8,9])
for i in range(k-1):
    first = q.popleft()
    if first%10-1 >= 0:
        q.append(first*10 + (first%10-1))
    q.append(first*10 + first%10)
    if first%10+1 <= 9:
        q.append(10*first + (first%10+1))
    print(q)
print(q[0])