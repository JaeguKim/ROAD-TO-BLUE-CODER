package prob24;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode newHead = p2;
        ListNode prevP2 = null;
        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            p2.next = p1;
            if (prevP2 != null) prevP2.next = p2;
            prevP2 = p1;
            p1 = p1.next;
            if (p1 != null) p2 = p1.next;
            else p2 = null;
        }
        return newHead;
    }
}
