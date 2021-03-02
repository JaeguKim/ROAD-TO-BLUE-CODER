import java.util.Stack;

// TIME : O(l1+l2), SPACE : O(l1+l2)
class Solution {

    public ListNode getReversedList(ListNode l){
        Stack<Integer> st = new Stack<>();
        ListNode cur = l;
        while (cur != null){
            st.push(cur.val);
            cur = cur.next;
        }
        ListNode head = null;
        cur = null;
        while (!st.empty()){
            ListNode newNode = new ListNode(st.pop());
            if (head == null){
                head = newNode;
            }
            else {
                cur.next = newNode;
            }
            cur = newNode;
        }
        return head;
    }

    public ListNode sumTwoList(ListNode l1, ListNode l2){
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode res = null;
        ListNode resCur = null;
        int adder = 0;
        while (c1 != null && c2 != null){
            int sum = c1.val+c2.val+adder;
            adder = sum/10;
            int digit = sum%10;
            ListNode newNode = new ListNode(digit);
            if (res == null){
                res = newNode;
            }
            else {
                resCur.next = newNode;
            }
            resCur = newNode;
            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null){
            int sum = c1.val+adder;
            int digit = sum%10;
            adder = sum/10;
            ListNode newNode = new ListNode(digit);
            if (res == null){
                res = newNode;
            }
            else {
                resCur.next = newNode;
            }
            resCur = newNode;
            c1 = c1.next;
        }
        while (c2 != null){
            int sum = c2.val+adder;
            int digit = sum%10;
            adder = sum/10;
            ListNode newNode = new ListNode(digit);
            if (res == null){
                res = newNode;
            }
            else {
                resCur.next = newNode;
            }
            resCur = newNode;
            c2 = c2.next;
        }
        
        if (adder == 1){
            resCur.next = new ListNode(1);
        }
        return res;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = getReversedList(l1);
        ListNode r2 = getReversedList(l2);
        ListNode res = sumTwoList(r1, r2);
        return getReversedList(res);
    } 
}