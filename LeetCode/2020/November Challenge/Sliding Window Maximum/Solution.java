import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// O(N) 풀이, 각각의 원소가 최대 한번 삭제, 삽입 되므로 O(2*N) = O(N)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<k; i++){
                while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                    deq.removeLast();
                }
                deq.add(i);
        }
        list.add(nums[deq.getFirst()]);
        for (int i=k; i<nums.length; i++){
            int left = i-k+1;
            if (deq.getFirst() < left) 
                deq.removeFirst();
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                deq.removeLast();
            }
            deq.add(i);
            list.add(nums[deq.getFirst()]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}

// O(N*K) 풀이. TLE
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
// 			@Override
// 			public int compare(Integer o1, Integer o2) {
//                 if (o2 < o1) return -1;
//                 else if (o2 == o1) return 0;
//                 else return 1;
// 			}
//         });
//         List<Integer> list = new ArrayList<>();
//         // PriorityQueue<Integer> pq = new PriorityQueue<>((Integer o1, Integer o2) -> {
//         //     if (o2 < o1) return -1;
//         //         else if (o2 == o1) return 0;
//         //         else return 1;
//         // });
//         for (int i=0; i<k; i++) {
//             pq.add(nums[i]);
//         }
//         list.add(pq.peek());
//         for (int i=k; i<nums.length; i++){
//             int left = i-k+1;
//             pq.remove(nums[left-1]);
//             pq.add(nums[i]);
//             list.add(pq.peek());
//         }
//         return list.stream().mapToInt(i -> i).toArray();
//     }
// }