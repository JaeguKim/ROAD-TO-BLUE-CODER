package 나무재테크;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static Grid[][] board;
    static int[][] addedNutrition;
    static int n;
    static DIR[] dirs = new DIR[]{DIR.U, DIR.UR, DIR.R, DIR.BR, DIR.B, DIR.BL, DIR.L, DIR.UL};

    static class Tree {
        int age;

        public Tree(int age) {
            this.age = age;
        }

        public void increment() {
            age++;
        }
    }

     static class Grid {
        int nutrition = 5;
        Deque<Tree> survivied = new ArrayDeque<>();
    }

    enum DIR {
        U(0), UR(1), R(2), BR(3), B(4), BL(5), L(6), UL(7);
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

        public boolean checkBound(int n, int m) {
            return (r >= 1 && r <= n && c >= 1 && c <= m);
        }
    }

    public static Pos newPos(Pos p, DIR d) {
        Pos newPos = null;
        if (d == DIR.U) {
            newPos = new Pos(p.r - 1, p.c);
        } else if (d == DIR.UR) {
            newPos = new Pos(p.r - 1, p.c + 1);
        } else if (d == DIR.R) {
            newPos = new Pos(p.r, p.c + 1);
        } else if (d == DIR.BR) {
            newPos = new Pos(p.r + 1, p.c + 1);
        } else if (d == DIR.B) {
            newPos = new Pos(p.r + 1, p.c);
        } else if (d == DIR.BL) {
            newPos = new Pos(p.r + 1, p.c - 1);
        } else if (d == DIR.L) {
            newPos = new Pos(p.r, p.c - 1);
        } else if (d == DIR.UL) {
            newPos = new Pos(p.r - 1, p.c - 1);
        }
        return newPos;
    }

    public static void springAndSummer() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int diedNutrition = 0;
                Deque<Tree> deq = board[i][j].survivied;
                int size = deq.size();
                for (int k=0;k<size;k++) {
                    Tree tree = deq.pollFirst();
                    if (board[i][j].nutrition >= tree.age) {
                        board[i][j].nutrition -= tree.age;
                        tree.increment();
                        deq.addLast(tree);
                    } else {
                        diedNutrition += tree.age/2;
                    }
                }
                board[i][j].nutrition += diedNutrition;
            }
        }
    }

    public static void fall() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                List<Tree> survived = board[i][j].survivied.stream().collect(Collectors.toList());
                for (Tree tree : survived) {
                    if (tree.age % 5 == 0) {
                        for (DIR d : dirs) {
                            Pos nextPos = newPos(new Pos(i, j), d);
                            if (nextPos.checkBound(n, n)) {
                                board[nextPos.r][nextPos.c].survivied.addFirst(new Tree(1));
                            }
                        }
                    }
                }
            }
        }
    }

    public static void winter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j].nutrition += addedNutrition[i][j];
            }
        }
    }


    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new Grid[n + 1][n + 1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                board[i][j] = new Grid();
            }
        }
        addedNutrition = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                addedNutrition[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            board[r][c].survivied.add(new Tree(age));
        }
        while (k-- > 0) {
            springAndSummer();
            fall();
            winter();
        }
        int ans = 0;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                ans += board[i][j].survivied.size();
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
