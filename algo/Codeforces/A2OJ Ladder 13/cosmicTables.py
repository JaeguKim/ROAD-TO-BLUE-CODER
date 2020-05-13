table = []
n,m,k = map(int,input().split())
rows = []
cols = []
for i in range(n):
    row = list(map(int,input().split()))
    table.append(row)
    rows.append(i)
for j in range(m):
    cols.append(j)
for i in range(k):
    query = input().split()
    q = query[0]
    n1 = int(query[1]); n2 = int(query[2])
    if q == 'c':
        temp = cols[n1-1]
        cols[n1-1] = cols[n2-1]
        cols[n2-1] = temp
    elif q == 'r':
        temp = rows[n1-1]
        rows[n1-1] = rows[n2-1]
        rows[n2-1] = temp
    elif q == 'g':
        row = rows[n1-1]
        col = cols[n2-1]
        print(table[row][col])

