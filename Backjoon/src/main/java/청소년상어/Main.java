package 청소년상어;

import java.io.*;

public class Main {

    static class Fish {
        int x;
        int y;
        int dir;
        boolean live;

        public Fish(int x, int y, int dir, boolean live) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.live = live;
        }

        public Fish copy() {
            return new Fish(x,y,dir,live);
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static int ans;
    static int[][] map = new int[4][4];
    static Fish[] fish = new Fish[20];

    static int[] dx = new int[]{0,-1,-1,0,1,1,1,0,-1};
    static int[] dy = new int[]{0,0,-1,-1,-1,0,1,1,1};

    public static void copy_state(int[][] A, int[][] B, Fish[] C, Fish[] D) {
        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++) {
                A[i][j] = B[i][j];
            }
        }
        for (int i=1;i<=16;i++) C[i] = D[i].copy();
    }

    public static void swap_fish(int idx, int iidx) {
        Fish temp = fish[idx].copy();
        fish[idx].x = fish[iidx].x;
        fish[idx].y = fish[iidx].y;
        fish[iidx].x = temp.x;
        fish[iidx].y = temp.y;
    }

    public static void move_fish() {
        for (int i=1;i<=16;i++) {
            if (fish[i].live == false) continue;
            int x = fish[i].x;
            int y = fish[i].y;
            int dir = fish[i].dir;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            boolean flag = false;
            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
                if (map[nx][ny] == 0) {
                    flag = true;
                    fish[i].x = nx;
                    fish[i].y = ny;
                    map[nx][ny] = i;
                    map[x][y] = 0;
                }
                else if (map[nx][ny] != -1) {
                    flag = true;
                    swap_fish(i,map[nx][ny]);
                    int temp = map[x][y];
                    map[x][y] = map[nx][ny];
                    map[nx][ny] = temp;
                }
            }

            if (flag == false) {
                int nDir = dir+1;
                if (nDir == 9) nDir = 1;
                nx = x+dx[nDir];
                ny = y+dy[nDir];

                while (nDir != dir) {
                    if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
                        if (map[nx][ny] == 0) {
                            fish[i].x = nx;
                            fish[i].y = ny;
                            map[nx][ny] = i;
                            map[x][y] = 0;
                            fish[i].dir = nDir;
                            break;
                        }
                        else if (map[nx][ny] != -1) {
                            swap_fish(i,map[nx][ny]);
                            int temp = map[x][y];
                            map[x][y] = map[nx][ny];
                            map[nx][ny] = temp;
                            fish[i].dir = nDir;
                            break;
                        }
                    }
                    nDir++;
                    if (nDir == 9) nDir = 1;
                    nx = x+dx[nDir];
                    ny = y+dy[nDir];
                }
            }
        }
    }

    public static void make_state(int x, int y, int nx, int ny, int fish_num, boolean T) {
        if (T == true) {
            map[x][y] = 0;
            map[nx][ny] = -1;
            fish[fish_num].live = false;
        }
        else {
            map[x][y] = -1;
            map[nx][ny] = fish_num;
            fish[fish_num].live = true;
        }
    }

    static void dfs(int x, int y, int dir, int sum) {
        ans = Math.max(ans,sum);
        int[][] c_map = new int[4][4];
        Fish[] c_fish = new Fish[20];
        copy_state(c_map,map,c_fish,fish);
        move_fish();
        for (int i=1;i<=3;i++) {
            int nx = x + dx[dir]*i;
            int ny = y + dy[dir]*i;
            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
                if (map[nx][ny] == 0) continue;
                int fish_num = map[nx][ny];
                int nDir = fish[fish_num].dir;
                make_state(x,y,nx,ny,fish_num,true);
                dfs(nx,ny,nDir,sum+fish_num);
                make_state(x,y,nx,ny,fish_num,false);
            }
            else break;
        }
        copy_state(map,c_map,fish,c_fish);
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<4; i++) {
            int a,b;
            String[] ary = br.readLine().split(" ");
            for (int j=0;j<8;j+=2) {
                a = Integer.parseInt(ary[j]);
                b = Integer.parseInt(ary[j+1]);
                map[i][j/2] = a;
                fish[a] = new Fish(i,j/2,b,true);
            }
        }
        int f_num = map[0][0];
        int dir = fish[f_num].dir;
        fish[f_num].live = false;
        map[0][0] = -1;
        dfs(0,0,dir,f_num);
        return ans;
    }


    public static void main(String[] args) throws IOException {
        int res = solve("test", false);
        bw.write(ans + "\n");
        bw.flush();
    }
}
