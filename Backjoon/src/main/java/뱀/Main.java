package 뱀;

import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[][] board;
    static Map<Integer,String> turn;
    static Deque<Pos> q;
    static Set<Pos> visited;
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean check;

    static class Pos {
        int r,c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return r == pos.r &&
                    c == pos.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    enum DIR {
        U(0),R(1),D(2),L(3);
        int d;
        DIR(int d) {
            this.d = d;
        }
    }

    public static void move(DIR d) {
        Pos head = q.getFirst();
        Pos newHead = null;
        int newR = 0;
        int newC = 0;
        if (d == DIR.U) {
            newR = head.r-1;
            newC = head.c;
        }
        else if (d == DIR.R) {
            newR = head.r;
            newC = head.c+1;
        }
        else if (d == DIR.D) {
            newR = head.r+1;
            newC = head.c;
        }
        else if (d == DIR.L) {
            newR = head.r;
            newC = head.c-1;
        }
        newHead = new Pos(newR,newC);
        if (visited.contains(newHead)) check = false;
        visited.add(newHead);
        q.addFirst(newHead);
        if (check()) {
            if (board[newR][newC] == 1) {
                board[newR][newC] = 0;
            } else {
                visited.remove(q.getLast());
                q.removeLast();
            }
        }
    }

    public static boolean check() {
        Pos h = q.getFirst();
        if (h.r < 1 || h.r > n || h.c < 1 || h.c > n) return false;
        return check;
    }

    public static DIR newDir(DIR d, String turnVal) {
        if (turnVal.equals("L")) {
            if (d == DIR.U) {
                d = DIR.L;
            }
            else if (d == DIR.R) {
                d = DIR.U;
            }
            else if (d == DIR.D) {
                d = DIR.R;
            }
            else if (d == DIR.L) {
                d = DIR.D;
            }
        }
        else if (turnVal.equals("D")) {
            if (d == DIR.U) {
                d = DIR.R;
            }
            else if (d == DIR.R) {
                d = DIR.D;
            }
            else if (d == DIR.D) {
                d = DIR.L;
            }
            else if (d == DIR.L) {
                d = DIR.U;
            }
        }
        return d;
    }

    public static int solve(String fname,boolean test) throws IOException {
        turn = new HashMap<>();
        q = new LinkedList<>();
        visited = new HashSet<>();
        check = true;
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];
        while (k-- > 0) {
            String[] ary = br.readLine().split(" ");
            int r = Integer.parseInt(ary[0]);
            int c = Integer.parseInt(ary[1]);
            board[r][c] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        while (l-- > 0) {
            String[] ary = br.readLine().split(" ");
            int t = Integer.parseInt(ary[0]);
            String s = ary[1];
            turn.put(t,s);
        }
        int t=0;
        DIR d = DIR.R;
        q.add(new Pos(1,1));
        visited.add(q.getFirst());
        while (check()) {
            String turnVal = turn.getOrDefault(t,null);
            if (turnVal != null) {
                d = newDir(d,turnVal);
            }
            move(d);
            t++;
        }
        return t;
    }

    public static void main(String[] args) throws IOException {
        int res = solve("test",false);
        bw.write(res+"\n");
        bw.flush();
    }
}
