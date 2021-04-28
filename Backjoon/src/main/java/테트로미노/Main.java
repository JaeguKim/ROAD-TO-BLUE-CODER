package 테트로미노;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

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

    static BufferedReader br;
    static BufferedWriter bw;
    static int R;
    static int C;
    static int[][] board;
    static int ans = Integer.MIN_VALUE;
    static int[][] type1_1 = new int[][]{{0,0},{0,1},{0,2},{0,3}};
    static int[][] type1_2 = new int[][]{{0,0},{1,0},{2,0},{3,0}};
    static int[][] type2 = new int[][]{{0,0},{0,1},{1,0},{1,1}};
    static int[][] type3_1 = new int[][]{{0,0},{1,0},{2,0},{2,1}};
    static int[][] type3_2 = new int[][]{{0,0},{0,1},{0,2},{-1,2}};
    static int[][] type3_3 = new int[][]{{0,0},{-1,0},{-2,0},{-2,-1}};
    static int[][] type3_4 = new int[][]{{0,0},{0,-1},{0,-2},{1,-2}};
    static int[][] type3_5 = new int[][]{{0,0},{0,1},{-1,1},{-2,1}};
    static int[][] type3_6 = new int[][]{{0,0},{0,1},{0,2},{1,2}};
    static int[][] type3_7 = new int[][]{{0,0},{0,-1},{1,-1},{2,-1}};
    static int[][] type3_8 = new int[][]{{0,0},{1,0},{1,1},{1,2}};
    static int[][] type4_1 = new int[][]{{0,0},{1,0},{1,1},{2,1}};
    static int[][] type4_2 = new int[][]{{0,0},{0,1},{-1,1},{-1,2}};
    static int[][] type4_3 = new int[][]{{0,0},{1,0},{1,-1},{2,-1}};
    static int[][] type4_4 = new int[][]{{0,0},{0,1},{1,1},{1,2}};
    static int[][] type5_1 = new int[][]{{0,0},{0,1},{0,2},{1,1}};
    static int[][] type5_2 = new int[][]{{0,0},{0,1},{-1,1},{1,1}};
    static int[][] type5_3 = new int[][]{{0,0},{0,1},{-1,1},{0,2}};
    static int[][] type5_4 = new int[][]{{0,0},{1,0},{1,1},{2,0}};


    public static void update(Pos cur,int[][][] types) {
        for (int[][] type : types) {
            int ans1 = 0;
            for (int[] offset : type) {
                Pos p = new Pos(cur.r+offset[0],cur.c+offset[1]);
                if (p.checkBound(R,C)) {
                    ans1 += board[p.r][p.c];
                }
                else {
                    ans1 = -1;
                    break;
                }
            }
            ans = Math.max(ans1,ans);
        }
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R+1][C+1];
        ans = 0;
        for (int i=1;i<=R;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=C;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=1;i<=R;i++) {
            for (int j=1;j<=C;j++) {
                update(new Pos(i,j),new int[][][]{
                        type1_1,type1_2,
                        type2,
                        type3_1,type3_2,type3_3,type3_4,type3_5,type3_6,type3_7,type3_8,
                        type4_1,type4_2,type4_3,type4_4,
                        type5_1,type5_2,type5_3,type5_4});
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
