import java.util.ArrayList;
import java.util.List;

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
class Solution {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        list.sort(null);
        ListNode newHead = null;
        for (int i=0; i<list.size(); i++){
            if (newHead == null){
                newHead = new ListNode(list.get(i));
                cur = newHead;
            }
            else {
                cur.next = new ListNode(list.get(i));
                cur = cur.next;
            }
        }
        return newHead;
    }
}