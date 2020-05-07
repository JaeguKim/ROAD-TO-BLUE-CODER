#30min
def printList(list):
    print(len(list),end=' ')
    for num in list:
        print(num,end=' ')
    print()

n = int(input())
ary = [int(ch) for ch in input().split()]
dict = {'pos':[],'neg':[],'zero':[]}
for num in ary:
    if num > 0:
        dict['pos'].append(num)
    elif num < 0:
        dict['neg'].append(num)
    else:
        dict['zero'].append(num)
firstSet = []
secondSet = []
thirdSet = []
if len(dict['pos']) > 0:
    list = dict['pos']
    firstSet.append(list[0])
    for num in list[1:]:
        thirdSet.append(num)
    secondSet.append(dict['neg'][0])
    for num in dict['neg'][1:]:
        thirdSet.append(num)
else:
    list = dict['neg']
    firstSet.append(list[0])
    firstSet.append(list[1])
    secondSet.append(list[2])
    for num in list[3:]:
        thirdSet.append(num)
list = dict['zero']
for num in list:
    thirdSet.append(num)

printList(secondSet)
printList(firstSet)
printList(thirdSet)


