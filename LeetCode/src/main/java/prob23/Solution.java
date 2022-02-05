package prob23;

import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedDummyHead = new ListNode();
        Set<Integer> set = new HashSet<>();
        ListNode[] nodeRefArr = new ListNode[lists.length];
        for (int i=0; i<lists.length; ++i) {
            if (lists[i] != null) {
                set.add(i);
                nodeRefArr[i] = lists[i];
            }
        }
        ListNode curNode = mergedDummyHead;
        while (!set.isEmpty()) {
            curNode.next = new ListNode();
            curNode = curNode.next;
            ListNode minNode = null;
            int idx = 0;
            for (int i=0; i<lists.length; ++i) {
                if (nodeRefArr[i] != null) {
                    if (minNode == null) {
                        minNode = nodeRefArr[i];
                        idx = i;
                    } else if (minNode.val > nodeRefArr[i].val) {
                        minNode = nodeRefArr[i];
                        idx = i;
                    }
                }
            }
            curNode.val = minNode.val;
            nodeRefArr[idx] = nodeRefArr[idx].next;
            if (nodeRefArr[idx] == null) set.remove(idx);
        }
        return mergedDummyHead.next;
    }
}