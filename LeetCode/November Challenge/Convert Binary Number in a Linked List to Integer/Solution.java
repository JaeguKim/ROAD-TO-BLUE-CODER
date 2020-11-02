/* O(1) Space */
class Solution {
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            //num = num * 2 + head.next.val;
            num = (num << 1) | head.next.val;
            head = head.next;
        }
        return num;
    }
}

/* Solution O(N) Space
class Solution {
    
    private String binaryString;
    public void setBinaryString(ListNode head){
        if (head == null) return;
        binaryString+=Integer.toString(head.val);
        setBinaryString(head.next);
    }
    public int getDecimalValue(ListNode head) {
        binaryString = "";
        setBinaryString(head);
        return Integer.parseInt(binaryString,2);
    }
}
*/