package baduk2;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] board;
    static List<Pos> emptyCells;
    static int n;
    static int m;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int ans = Integer.MIN_VALUE;

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean checkBound(int n, int m) {
            return (r >= 1 && r <= n && c >= 1 && c <= m);
        }
    }

    public static void bruteForce() {
        for (int i=0;i<emptyCells.size();i++) {
            for (int j=i+1;j<emptyCells.size();j++) {
                int[][] backup = backup();
                putStone(emptyCells.get(i),emptyCells.get(j));
                int deadCnt = simulate();
                ans = Math.max(ans,deadCnt);
                board = backup;
            }
        }
    }

    public static int[][] backup() {
        int[][] backup = new int[n+1][m+1];
        for (int i=1;i<=n;i++) {
            System.arraycopy(board[i], 0, backup[i], 0, m + 1);
        }
        return backup;
    }


    public static void putStone(Pos p1, Pos p2) {
        board[p1.r][p1.c] = 1;
        board[p2.r][p2.c] = 1;
    }

    public static int simulate() {
        int deadCnt = 0;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++) {
                if (board[i][j] == 2) {
                    deadCnt += bfs(new Pos(i,j));
                }
            }
        }
        return deadCnt;
    }

    public static int bfs(Pos start) {
        Queue<Pos> que = new LinkedList<>();
        que.add(start);
        boolean isBlank = false;
        int connected = 0;
        board[start.r][start.c] = -1;
        while (que.size() > 0) {
            Pos front = que.poll();
            connected++;
            for (int i=0;i<4;i++) {
                Pos newPos = new Pos(front.r+dx[i],front.c+dy[i]);
                if (newPos.checkBound(n,m)) {
                    if (board[newPos.r][newPos.c] == 0) {
                        isBlank = true;
                    }
                    else if (board[newPos.r][newPos.c] == 2) {
                        board[newPos.r][newPos.c] = -1;
                        que.add(newPos);
                    }
                }
            }
        }
        if (isBlank) {
            return 0;
        }
        else {
            return connected;
        }
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];
        emptyCells = new ArrayList<>();
        ans = Integer.MIN_VALUE;
        for (int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=m;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    emptyCells.add(new Pos(i,j));
                }
            }
        }
        bruteForce();
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
