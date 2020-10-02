import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    private Queue<Integer> que;

    public RecentCounter() {
        que = new LinkedList<>();
    }

    public int ping(int t) {
        que.add(t);
        while (que.peek() < t - 3000) {
            que.remove();
        }
        return que.size();
    }
}
