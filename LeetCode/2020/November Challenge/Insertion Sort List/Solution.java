//맨 앞에있는 원소부터 시작해서 새로운 리스트에 자리를 찾아서 넣는다
//삽입할 노드가 새로운 리스트 노드값보다 작거나 같은경우, 위치표시 break
//위차가 null이면 맨뒤에 삽입
//아니면 해당 위치 앞에 삽입
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode newList = null;
        ListNode cur = head;
        while (cur != null){
            if (newList == null) newList = new ListNode(cur.val);
            else {
                ListNode newCur = newList;
                ListNode prev = null;
                while (newCur != null){
                    if (cur.val <= newCur.val){
                        ListNode newNode = new ListNode(cur.val);
                        if (prev == null){
                            newNode.next = newCur;
                            newList = newNode;
                        }
                        else {
                            prev.next = newNode;
                            newNode.next = newCur;
                        }
                        break;
                    }                    
                    prev = newCur;
                    newCur = newCur.next;
                }
                if (newCur == null) prev.next = new ListNode(cur.val);
            }
            cur = cur.next;
        }
        return newList;
    }
}