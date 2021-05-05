package 키순서;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static List<List<Integer>> graph;
    static int[] smaller;
    static int[] larger;

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        smaller = new int[n+1];
        larger = new int[n+1];
        for (int i=0;i<n+1;i++) {
            graph.add(new ArrayList<>());
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i=1;i<=n;i++) {
            boolean[] visited = new boolean[n+1];
            que.clear();
            que.add(i);
            while (que.size() > 0) {
                int front = que.poll();
                visited[front] = true;
                for (int v : graph.get(front)) {
                    if (visited[v] == false) {
                        smaller[v]++;
                        larger[i]++;
                        que.add(v);
                        visited[v] = true;
                    }
                }
            }
        }
        int ans = 0;
        for (int i=1;i<=n;i++) {
            if (smaller[i]+larger[i] == n-1) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
