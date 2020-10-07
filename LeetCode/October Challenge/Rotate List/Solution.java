import java.util.ArrayList;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {  
    public ListNode rotateRight(ListNode head, int k) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list1.add(cur.val);
            cur = cur.next;
        }
        if (list1.size() == 0) return null;
        int[] arr = new int[list1.size()];
        for (int i=0; i<list1.size(); i++){
            arr[(i+k)%list1.size()] = list1.get(i);
        }
        ListNode newHead = null;
        for (int i=0; i<arr.length; i++){
            if (newHead == null){
                newHead = new ListNode(arr[i]);
                cur = newHead;
            }
            else{
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }
        return newHead;
    }
}