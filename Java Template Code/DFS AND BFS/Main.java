import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs는 priority queue
// n(정점갯수), m(edge개수), v(시작번호)
// m line, start,end

class Edge implements Comparable<Edge> {
    int start;
    int end;

    public Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Edge o) {
        if (start != o.start)
            return start - o.start;
        return end - o.end;
    }
}

public class Main {

    static HashMap<Integer, List<Integer>> adjList;
    static HashSet<Integer> visited;
    static List<Integer> ans;

    static void dfs(int node) {
        if (visited.contains(node))
            return;
        visited.add(node);
        ans.add(node);
        if (adjList.containsKey(node)) {
            for (int next : adjList.get(node)) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited.add(start);
        while (!que.isEmpty()) {
            int front = que.poll();
            ans.add(front);
            if (adjList.containsKey(front)) {
                for (int next : adjList.get(front)) {
                    if (visited.contains(next))
                        continue;
                    visited.add(next);
                    que.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int start = Integer.parseInt(tokenizer.nextToken());
        adjList = new HashMap<>();
        visited = new HashSet<>();
        ans = new ArrayList<>();
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(tokenizer.nextToken());
            int e = Integer.parseInt(tokenizer.nextToken());
            edges.add(new Edge(s, e));
            edges.add(new Edge(e, s));
        }
        Collections.sort(edges);
        for (int i = 0; i < edges.size(); i++) {
            int s = edges.get(i).start;
            int e = edges.get(i).end;
            if (!adjList.containsKey(s))
                adjList.put(s, new ArrayList<Integer>());
            adjList.get(s).add(e);
        }
        dfs(start);
        for (int i = 0; i < ans.size(); i++) {
            if (i == ans.size() - 1) {
                bw.write(ans.get(i) + "\n");
                break;
            }
            bw.write(ans.get(i) + " ");
        }
        ans.clear();
        visited.clear();    
        bfs(start);
        for (int i = 0; i < ans.size(); i++) {
            if (i == ans.size() - 1) {
                bw.write(ans.get(i) + "\n");
                break;
            }
            bw.write(ans.get(i) + " ");
        }
        bw.flush();
    }
}
