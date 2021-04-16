N = int(input())
cards = [i+1 for i in range(N)]
dumps = []
while len(cards) > 1:
    top = cards[0]
    dumps.append(top)
    cards.pop(0)
    if len(cards) > 1:
        top = cards[0]
        cards.pop(0)
        cards.append(top)
dumps.append(cards[0])
for i,num in enumerate(dumps):
    if i == len(dumps)-1:
        print(num,end='')
    else:
        print(num,end=' ')
     

