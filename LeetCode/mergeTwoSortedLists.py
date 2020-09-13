# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        curL1 = l1; curL2 = l2;
        newListNode = None; curNew = None
        while curL1 != None and curL2 != None:
            newNode = ListNode()
            if curL1.val < curL2.val:
                newNode.val = curL1.val
                curL1 = curL1.next
            else:
                newNode.val = curL2.val
                curL2 = curL2.next
            if curNew == None:
                newListNode = newNode
            else:
                curNew.next = newNode
            curNew = newNode
            
        while curL1 != None:
            newNode = ListNode()
            newNode.val = curL1.val
            if curNew == None:
                newListNode = newNode
            else:
                curNew.next = newNode
            curNew = newNode
            curL1 = curL1.next
        
        while curL2 != None:
            newNode = ListNode()
            newNode.val = curL2.val
            if curNew == None:
                newListNode = newNode
            else:
                curNew.next = newNode
            curNew = newNode
            curL2 = curL2.next
            
        return newListNode
        