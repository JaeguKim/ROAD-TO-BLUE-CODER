package 연구소;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[][] board;
    static List<Pos> emptyList;
    static List<Pos> virusPosList;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
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

    public static void bfs() {
        Queue<Pos> que = new LinkedList<>();
        virusPosList.stream().forEach(pos -> que.add(pos));
        while (que.size() > 0) {
            Pos p = que.poll();
            for (int i=0;i<4;i++) {
                Pos newPos = new Pos(p.r+dx[i],p.c+dy[i]);
                if (newPos.checkBound(N,M) && board[newPos.r][newPos.c] == 0) {
                    board[newPos.r][newPos.c] = 2;
                    que.add(newPos);
                }
            }
        }
    }

    public static void mark(Set<Integer> visited) {
        visited.stream().forEach(i -> board[emptyList.get(i).r][emptyList.get(i).c] = 1);
    }

    public static int[][] backup() {
        int[][] backup = new int[N+1][M+1];
        for (int i=0;i<N+1;i++) {
            for (int j=0;j<M+1;j++) {
                backup[i][j] = board[i][j];
            }
        }
        return backup;
    }

    public static int calcSafeArea() {
        int ans = 0;
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=M;j++) {
                if (board[i][j] == 0){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(Set<Integer> visited) {
        if (visited.size() == 3) {
            int[][] backup = backup();
            mark(visited);
            bfs();
            ans = Math.max(ans,calcSafeArea());
            board = backup;
            return;
        }
        for (int i=0;i<emptyList.size();i++) {
            if (visited.contains(i)) return;
            visited.add(i);
            dfs(visited);
            visited.remove(i);
        }
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        ans = Integer.MIN_VALUE;
        emptyList = new ArrayList<>();
        virusPosList = new ArrayList<>();
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    emptyList.add(new Pos(i,j));
                }
                else if (board[i][j] == 2) {
                    virusPosList.add(new Pos(i,j));
                }
            }
        }
        dfs(new HashSet<>());
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
