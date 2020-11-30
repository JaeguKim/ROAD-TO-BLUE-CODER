import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public boolean bfs(int[] arr, int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        Set<Integer> visited = new HashSet<>();
        while (que.size() > 0) {
            int idx = que.poll();
            int l = idx - arr[idx];
            int r = idx + arr[idx];
            if (l >= 0 && visited.contains(l) == false) {
                if (arr[l] == 0) return true;
                que.add(l);
                visited.add(l);
            }
            if (r < arr.length && visited.contains(r) == false) {
                if (arr[r] == 0) return true;
                que.add(r);
                visited.add(r);
            } 
        }
        return false;
    }

    public boolean dfs(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) return true;
            arr[start] = -arr[start];
            return dfs(arr,start - arr[start]) || dfs(arr,start + arr[start]);
        }
        return false;
    }

    public boolean canReach(int[] arr, int start) {
        return bfs(arr,start);
    }
}
