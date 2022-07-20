package prob630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int currentTotalTime = 0;
        for (int[] course : courses) {
            if (currentTotalTime + course[0] <= course[1]) {
                currentTotalTime += course[0];
                pq.add(course[0]);
            } else if (pq.size() > 0 && pq.peek() > course[0]) {
                currentTotalTime = currentTotalTime - pq.poll() + course[0];
                pq.add(course[0]);
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.scheduleCourse(new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}});
        System.out.println(ans);
        ans = sol.scheduleCourse(new int[][]{{1,2}});
        System.out.println(ans);
        ans = sol.scheduleCourse(new int[][]{{3,2},{4,3}});
        System.out.println(ans);
    }
}
