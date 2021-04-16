import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

    int idx;
    int cnt;

    public Node(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        return cnt - o.cnt;
    }

}

public class Main {

    static int dp[];
    static int n, k;
    static int SIZE = 100001;
    static HashMap<Integer, List<Integer>> adjList;

    public static boolean checkBound(int idx) {
        if (idx < 0 || idx > SIZE - 1)
            return false;
        return true;
    }

    public static void runDijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new Node(n,0));
        while (!pq.isEmpty()){
            Node front = pq.poll();
            if (visited.contains(front.idx)) continue;
            visited.add(front.idx);
            for (int nextIdx : adjList.get(front.idx)){
                int newCnt;
                if (nextIdx == front.idx * 2){
                    newCnt = dp[front.idx];
                }
                else{
                    newCnt = dp[front.idx]+1;
                }
                if (newCnt < dp[nextIdx]){
                    dp[nextIdx] = newCnt;
                    pq.add(new Node(nextIdx,newCnt));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        dp = new int[SIZE];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        adjList = new HashMap<>();
        for (int i = 0; i < SIZE; i++) {
            adjList.put(i, new ArrayList<>());
            if (checkBound(i - 1)) {
                adjList.get(i).add(i - 1);
            }
            if (checkBound(i + 1)) {
                adjList.get(i).add(i + 1);
            }
            if (checkBound(2 * i)) {
                adjList.get(i).add(2 * i);
            }
        }
        runDijkstra();
        bw.write(dp[k] + "");
        bw.flush();
    }
}
