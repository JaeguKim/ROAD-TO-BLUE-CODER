package 게리맨더링2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] map;
    static int[][] group;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static void dfs(int r, int c, int value) {
        if (r < 0 || r > N-1 || c < 0 || c > N-1) return;
        if (group[r][c] != 0) return;
        group[r][c] = value;
        for (int i=0;i<4;i++) {
            dfs(r+dx[i],c+dy[i],value);
        }
    }

    public static int divide(int x, int y, int d1, int d2) {
        for (int i=0;i<=d1;i++) {
            group[x+i][y-i] = 5;
            group[x+d2+i][y+d2-i] = 5;
        }
        for (int i=0;i<=d2;i++) {
            group[x+i][y+i] = 5;
            group[x+d1+i][y-d1+i] = 5;
        }
        for (int r=x-1;r>=0;--r) {
            group[r][y] = 1;
        }
        for (int c = y+d2+1;c<N;++c) {
            group[x+d2][c] = 2;
        }
        for (int c=y-d1-1;c>=0;--c) {
            group[x+d1][c] = 3;
        }
        for (int r=x+d1+d2+1;r<N;++r) {
            group[r][y-d1+d2] = 4;
        }
        dfs(0,0,1);
        dfs(0,N-1,2);
        dfs(N-1,0,3);
        dfs(N-1,N-1,4);
        int[] people = new int[6];
        for (int r=0;r<N;++r) {
            for (int c=0;c<N;++c) {
                people[group[r][c]] += map[r][c];
            }
        }
        people[5] += people[0];
        int minP = Integer.MAX_VALUE;
        int maxP = Integer.MIN_VALUE;
        for (int i=1;i<=5;++i) {
            minP = Math.min(minP,people[i]);
            maxP = Math.max(maxP,people[i]);
        }
        return maxP-minP;
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[20][20];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x=0;x<=N-3;++x) {
            for (int y=1;y<=N-2;++y) {
                for (int d1=1;d1<=N-1 && y-d1 >= 0; ++d1) {
                    for (int d2=1;x+d1+d2<=N-1 && y-d1+d2 <= N-1; ++d2) {
                        group = new int[20][20];
                        ans = Math.min(ans,divide(x,y,d1,d2));
                    }
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
