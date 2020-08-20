# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        nodes = []
        temp = head
        while temp != None:
            nodes.append(temp)
            temp = temp.next
        n = len(nodes)
        if n == 0:
            return
        toRight = True
        leftIdx = 0; rightIdx = n-1
        for i in range(n-1):
            if toRight:
                nodes[leftIdx].next = nodes[rightIdx]
                leftIdx+=1
            else:
                nodes[rightIdx].next = nodes[leftIdx]
                rightIdx-=1
            toRight = not toRight
        if toRight:
            nodes[leftIdx].next = None
        else:
            nodes[rightIdx].next = None
        
    
        