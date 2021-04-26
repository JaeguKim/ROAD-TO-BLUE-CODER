package 미세먼지안녕;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    enum Dir {
        U(0), UR(1), R(2), BR(3), B(4), BL(5), L(6), UL(7);
        int d;

        Dir(int d) {
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

    static BufferedReader br;
    static BufferedWriter bw;

    static Dir[] dirs = new Dir[]{Dir.U, Dir.R, Dir.B, Dir.L};
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int R;
    static int C;
    static int T;
    static int[][] dustAmount;
    static List<Pos> purifierPos = new ArrayList<>();

    public static void spreadDust() {
        List<Pos> list = new ArrayList<>();
        for (int i=1;i<=R;i++) {
            for (int j=1;j<=C;j++) {
                if (dustAmount[i][j] > 0) {
                    list.add(new Pos(i,j));
                }
            }
        }
        List<Integer> tempDustCount = new ArrayList<>();
        for (Pos p : list) {
            tempDustCount.add(dustAmount[p.r][p.c]);
        }
        for (int i=0;i<list.size();i++) {
            Pos p = list.get(i);
            int spreadCnt = 0;
            int spreadAmount = tempDustCount.get(i)/5;
            for (int j=0;j<4;j++) {
                Pos nextPos = new Pos(p.r+dx[j],p.c+dy[j]);
                if (nextPos.checkBound(R,C) && dustAmount[nextPos.r][nextPos.c] != -1) {
                    spreadCnt++;
                    dustAmount[nextPos.r][nextPos.c] += spreadAmount;
                }
            }
            dustAmount[p.r][p.c] -= spreadAmount*spreadCnt;
        }
    }

    public static void setPurifierPos() {
        for (int i=1;i<=R;i++) {
            if (dustAmount[i][1] == -1) {
                purifierPos.add(new Pos(i,1));
            }
        }
    }

    public static List<Pos> getCWisePos() {
        List<Pos> c_wise_pos = new ArrayList<>();
        for (int r = purifierPos.get(0).r-1; r>=1;r--) {
            c_wise_pos.add(new Pos(r,1));
        }
        for (int c=2;c<=C;c++) {
            c_wise_pos.add(new Pos(1,c));
        }
        for (int r=2;r<=purifierPos.get(0).r;r++) {
            c_wise_pos.add(new Pos(r,C));
        }
        for (int c=C-1;c>=2;c--) {
            c_wise_pos.add(new Pos(purifierPos.get(0).r,c));
        }
        return c_wise_pos;
    }

    public static List<Pos> getWisePos() {
        List<Pos> wise_pos = new ArrayList<>();

        for (int r = purifierPos.get(1).r+1;r<=R;r++) {
            wise_pos.add(new Pos(r,1));
        }
        for (int c=2;c<=C;c++) {
            wise_pos.add(new Pos(R,c));
        }
        for (int r=R-1;r>=purifierPos.get(1).r;r--) {
            wise_pos.add(new Pos(r,C));
        }
        for (int c=C-1;c>=2;c--) {
            wise_pos.add(new Pos(purifierPos.get(1).r,c));
        }
        return wise_pos;
    }

    public static void MoveDust(List<Pos> list) {
        for (int i=1;i<list.size();i++) {
            Pos prev = list.get(i-1);
            Pos cur = list.get(i);
            dustAmount[prev.r][prev.c] = dustAmount[cur.r][cur.c];
        }
        Pos last = list.get(list.size()-1);
        dustAmount[last.r][last.c] = 0;
    }

    public static void purify() {
        List<Pos> cWisePos = getCWisePos();
        List<Pos> wisePos = getWisePos();
        MoveDust(cWisePos);
        MoveDust(wisePos);
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        dustAmount = new int[R+1][C+1];
        for (int i=1;i<=R;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=C;j++) {
                dustAmount[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setPurifierPos();
        while (T-- > 0) {
            spreadDust();
            purify();
        }
        int ans = 0;
        for (int i=1;i<=R;i++) {
            for (int j=1;j<=C;j++) {
                if (dustAmount[i][j] > 0) {
                    ans += dustAmount[i][j];
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
