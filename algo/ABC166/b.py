n,k = [int(ch) for ch in input().split()]
snuckList = []
for i in range(n):
    snuckList.append(i+1)
for i in range(k):
    cnt = int(input())
    snucks = [int(ch) for ch in input().split()]
    for snuck in snucks:
        if snuck in snuckList: 
            snuckList.remove(snuck)
print(len(snuckList))