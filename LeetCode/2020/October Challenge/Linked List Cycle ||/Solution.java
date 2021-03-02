import java.util.HashSet;

  class ListNode {
      int val;
      ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
  }
// head부터 시작해서 hashSet에 지나온 노드들을 넣는다 다음 노드가 null 이면 return null
// 다음 노드가 이미 방문한 노드이면 현재노드를 반환한다.
public class Solution {

    private HashSet<ListNode> visited;
    public ListNode detectCycle(ListNode head) {
        if (visited == null) visited = new HashSet<>();
        if (head == null) return null;
        else if (visited.contains(head)) return head;
        visited.add(head);
        return detectCycle(head.next);
    }
}
