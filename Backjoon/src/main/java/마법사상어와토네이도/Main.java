package 마법사상어와토네이도;

import java.io.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] board;
    static int n;
    static int[][] percentL = new int[][]{{0,0,2,0,0}, {0,10,7,1,0}, {5,0,0,0,0}, {0,10,7,1,0}, {0,0,2,0,0}};
    static int[][] percentR = new int[][]{{0,0,2,0,0}, {0,1,7,10,0}, {0,0,0,0,5}, {0,1,7,10,0},{0,0,2,0,0}};
    static int[][] percentD = new int[][]{{0,0,0,0,0},{0,1,0,1,0},{2,7,0,7,2},{0,10,0,10,0},{0,0,5,0,0}};
    static int[][] percentU = new int[][]{{0,0,5,0,0},{0,10,0,10,0},{2,7,0,7,2},{0,1,0,1,0},{0,0,0,0,0}};
    static int ans;
    static int moveCnt;
    static int iter;
    static DIR dir;
    static Pos cur;

    enum DIR {
        U(0), R(1), D(2), L(3);
        int d;

        DIR(int d) {
            this.d = d;
        }
    }

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean check(Pos p) {
        return p.r >= 1 && p.r <= n && p.c >= 1 && p.c <= n;
    }

    public static void update() {
        int[][] percent = null;
        Pos leftTop = new Pos(cur.r - 2, cur.c - 2);
        Pos a = null;
        if (dir == DIR.L) {
            percent = percentL;
            a = new Pos(cur.r, cur.c - 1);
        } else if (dir == DIR.R) {
            percent = percentR;
            a = new Pos(cur.r, cur.c + 1);
        } else if (dir == DIR.U) {
            percent = percentU;
            a = new Pos(cur.r-1,cur.c);
        } else if (dir == DIR.D) {
            percent = percentD;
            a = new Pos(cur.r+1,cur.c);
        }
        int total = board[cur.r][cur.c];
        int val = board[cur.r][cur.c];
        for (int i = 0; i < percent.length; i++) {
            for (int j = 0; j < percent[0].length; j++) {
                int amount = (int)(val * ((float)percent[i][j]/100));
                Pos pos = new Pos(leftTop.r+i,leftTop.c+j);
                if (check(pos)) {
                    board[pos.r][pos.c] += amount;
                } else {
                    ans += amount;
                }
                total -= amount;
            }
        }
        if (check(a)) {
            board[a.r][a.c] += total;
        } else {
            ans += total;
        }
        if (moveCnt == 1) {
            if (dir == DIR.D || dir == DIR.U) {
                iter++;
            }
            moveCnt = iter;
            dir = nextDir(dir);
        }
        else {
            moveCnt--;
        }
    }

    public static DIR nextDir(DIR dir) {
        DIR newDir = null;
        if (dir == DIR.L) {
            newDir = DIR.D;
        } else if (dir == DIR.D) {
            newDir = DIR.R;
        } else if (dir == DIR.R) {
            newDir = DIR.U;
        } else if (dir == DIR.U) {
            newDir = DIR.L;
        }
        return newDir;
    }

    public static void move() {
        if (dir == DIR.L) {
            cur = new Pos(cur.r,cur.c-1);
        }
        else if (dir == DIR.D) {
            cur = new Pos(cur.r+1, cur.c);
        }
        else if (dir == DIR.R) {
            cur = new Pos(cur.r, cur.c + 1);
        } else if (dir == DIR.U) {
            cur = new Pos(cur.r-1, cur.c);
        }
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        ans = 0;
        moveCnt = 1;
        iter = 1;
        dir = DIR.L;
        cur = new Pos(n / 2 + 1, n / 2 + 1);
        for (int i=0;i<n;i++) {
            String[] r = br.readLine().split(" ");
            for (int j=0;j<n;j++) {
                board[i+1][j+1] = Integer.parseInt(r[j]);
            }
        }
        moveCnt = iter;
        while (!(cur.r == 1 && cur.c == 1)) {
            move();
            update();
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int res = solve("test",false);
        bw.write(ans+"\n");
        bw.flush();
    }
}
