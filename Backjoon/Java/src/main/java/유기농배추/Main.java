package 유기농배추;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static class Pos {
        int r;
        int c;
        public Pos(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void bfs(int[][] map, int r, int c){
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int m = map.length;
        int n = map[0].length;
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(r,c));
        while (que.size() > 0){
            Pos pos = que.poll();
            map[pos.r][pos.c] = 0;
            for (int i=0;i<4;i++){
                int newR = pos.r+dx[i];
                int newC = pos.c+dy[i];
                if (newR >= 0 && newR < m && newC >= 0 && newC < n && map[newR][newC] == 1) {
                    map[newR][newC] = 0;
                    que.add(new Pos(newR,newC));
                }
            }
        }
    }

    public static int getAns(int[][] map, int m, int n){
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 1){
                    ans+=1;
                    bfs(map,i,j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            int[][] map = new int[m][n];
            while(k-- > 0){
                tokenizer = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(tokenizer.nextToken());
                int c = Integer.parseInt(tokenizer.nextToken());
                map[r][c] = 1;
            }
            bw.write(""+getAns(map,m,n));
            bw.flush();
            bw.newLine();
        }
    }
}
