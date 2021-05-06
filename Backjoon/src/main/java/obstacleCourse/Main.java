package obstacleCourse;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Point implements Comparable<Point> {
        int r,c,cost;
        public Point(int r,int c,int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost-o.cost;
        }

        public boolean checkBound(int n, int m) {
            return (r >= 0 && r < n && c >= 0 && c < m);
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int[][] map;
    static int[][] minCost;
    static int[] dy = {0,1,-1,0};
    static int[] dx = {1,0,0,-1};

    public static int dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        minCost[0][0] = map[0][0];
        pq.offer(new Point(0,0,map[0][0]));
        while (pq.size() > 0) {
            Point p = pq.poll();
            for (int k=0;k<4;k++) {
                Point newPoint = new Point(p.r + dy[k],p.c + dx[k],0);
                if (newPoint.checkBound(N,N)) {
                    if (minCost[newPoint.r][newPoint.c] > minCost[p.r][p.c]+map[newPoint.r][newPoint.c]) {
                        minCost[newPoint.r][newPoint.c] = minCost[p.r][p.c]+map[newPoint.r][newPoint.c];
                        newPoint.cost = minCost[newPoint.r][newPoint.c];
                        pq.offer(newPoint);
                    }
                }
            }
        }
        return minCost[N-1][N-1];
    }

    public static String solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            map = new int[N][N];
            minCost = new int[N][N];
            for (int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    minCost[i][j] = Integer.MAX_VALUE;
                }
            }
            cnt++;
            sb.append("Problem " + cnt + ": " + dijkstra() + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
