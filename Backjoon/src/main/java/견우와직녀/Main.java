package 견우와직녀;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int r, c, t;
        boolean isCrossed;

        public Info(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.isCrossed = false;
        }

        public boolean checkBound(int n, int m) {
            return (r >= 1 && r <= n && c >= 1 && c <= m);
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] minTime;
    static int[][] board;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N;

    public static void bfs() {
        minTime[1][1] = 0;
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(1,1,0));
        while (que.size() > 0) {
            Info first = que.poll();
            for (int i=0;i<4;i++) {
                Info next = new Info(first.r+dx[i],first.c+dy[i],first.t+1);
                if (next.checkBound(N,N)) {
                    if (board[next.r][next.c] == 0) {
                        continue;
                    }
                    if (board[next.r][next.c] >= 2) {
                        if (first.isCrossed) {
                            continue;
                        }
                        int waitTime = 0;
                        if (next.t % board[next.r][next.c] > 0) {
                            waitTime = board[next.r][next.c]-(next.t % board[next.r][next.c]);
                        }
                        next.t += waitTime;
                        next.isCrossed = true;
                    }
                    else {
                        next.isCrossed = false;
                    }
                    if (next.t < minTime[next.r][next.c]) {
                        minTime[next.r][next.c] = next.t;
                        que.add(next);
                    }
                }
            }
        }
    }

    public static int[][] backup() {
        int[][] backup = new int[N+1][N+1];
        for (int i=1;i<=N;i++) {
            System.arraycopy(board[i],0,backup[i],0,N+1);
        }
        return backup;
    }

    public static void initMinTime() {
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        minTime = new int[N+1][N+1];
        board = new int[N+1][N+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if (i==1 && j==1) {
                    continue;
                }
                if (board[i][j] == 0) {
                    int[][] backup = backup();
                    initMinTime();
                    board[i][j] = M;
                    bfs();
                    ans = Math.min(ans,minTime[N][N]);
                    board = backup;
                }
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
