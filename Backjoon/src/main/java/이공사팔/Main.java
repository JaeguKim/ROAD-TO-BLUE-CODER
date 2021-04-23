package 이공사팔;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Block {
        boolean isMerged = false;
        int num;
        Pos p;
        public Block(int num,boolean isMerged,Pos p) {
            this.num = num;
            this.isMerged = isMerged;
            this.p = p;
        }
        public Block copy() {
            return new Block(num,isMerged,p);
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

    enum Dir {
        U(0), UR(1), R(2), BR(3), B(4), BL(5), L(6), UL(7);
        int d;

        Dir(int d) {
            this.d = d;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;

    static Block[][] board;
    static int n;
    static int ans;
    static Dir[] dirs = new Dir[]{Dir.U,Dir.R,Dir.B,Dir.L};

    public static List<Block> getBlocksOrderly(Dir dir) {
        List<Block> list = new ArrayList<>();
        if (dir == Dir.R) {
            for (int r=1;r<=n;r++) {
                for (int c=n;c>=1;c--) {
                    if (board[r][c] != null) {
                        list.add(board[r][c]);
                    }
                }
            }
        }
        else if (dir == Dir.L) {
            for (int r=1;r<=n;r++) {
                for (int c=1;c<=n;c++) {
                    if (board[r][c] != null) {
                        list.add(board[r][c]);
                    }
                }
            }
        }
        else if (dir == Dir.U) {
            for (int c=1;c<=n;c++) {
                for (int r=1;r<=n;r++) {
                    if (board[r][c] != null) {
                        list.add(board[r][c]);
                    }
                }
            }
        }
        else if (dir == Dir.B) {
            for (int c=1;c<=n;c++) {
                for (int r=n;r>=1;r--) {
                    if (board[r][c] != null) {
                        list.add(board[r][c]);
                    }
                }
            }
        }
        return list;
    }

    public static void moveOrMerge(Dir d) {
        List<Block> blocks = getBlocksOrderly(d);
        if (d == Dir.R) {
            for (Block b : blocks) {
                Pos blockPos = b.p;
                for (int c=blockPos.c+1;c<=n;c++) {
                    if (board[blockPos.r][c] == null) {
                        board[blockPos.r][c] = b;
                        board[blockPos.r][blockPos.c] = null;
                        b.p = new Pos(blockPos.r,c);
                        blockPos = b.p;
                    } else if (board[blockPos.r][c].num == b.num) {
                        if (b.isMerged || board[blockPos.r][c].isMerged) break;
                        board[blockPos.r][c].num *= 2;
                        ans = Math.max(ans,board[blockPos.r][c].num);
                        board[blockPos.r][c].isMerged = true;
                        board[blockPos.r][blockPos.c] = null;
                        b.p = new Pos(blockPos.r,c);
                        break;
                    }
                }
            }
        }
        else if (d == Dir.L) {
            for (Block b : blocks) {
                Pos blockPos = b.p;
                for (int c=blockPos.c-1;c>=1;c--) {
                    if (board[blockPos.r][c] == null) {
                        board[blockPos.r][c] = b;
                        board[blockPos.r][blockPos.c] = null;
                        b.p = new Pos(blockPos.r,c);
                        blockPos = b.p;
                    } else if (board[blockPos.r][c].num == b.num) {
                        if (b.isMerged || board[blockPos.r][c].isMerged) break;
                        board[blockPos.r][c].num *= 2;
                        ans = Math.max(ans,board[blockPos.r][c].num);
                        board[blockPos.r][c].isMerged = true;
                        board[blockPos.r][blockPos.c] = null;
                        b.p = new Pos(blockPos.r,c);
                        break;
                    }
                }
            }
        }
        else if (d == Dir.U) {
            for (Block b : blocks) {
                Pos blockPos = b.p;
                for (int r=blockPos.r-1;r>=1;r--) {
                    if (board[r][blockPos.c] == null) {
                        board[r][blockPos.c] = b;
                        board[blockPos.r][blockPos.c] = null;
                        b.p = new Pos(r,blockPos.c);
                        blockPos = b.p;
                    } else if (board[r][blockPos.c].num == b.num) {
                        if (b.isMerged || board[r][blockPos.c].isMerged) break;
                        board[r][blockPos.c].num *= 2;
                        ans = Math.max(ans,board[r][blockPos.c].num);
                        board[r][blockPos.c].isMerged = true;
                        board[blockPos.r][blockPos.c] = null;
                        b.p = new Pos(r,blockPos.c);
                        break;
                    }
                }
            }
        }
        else if (d == Dir.B) {
            for (Block b : blocks) {
                Pos blockPos = b.p;
                for (int r=blockPos.r+1;r<=n;r++) {
                    if (board[r][blockPos.c] == null) {
                        board[r][blockPos.c] = b;
                        board[blockPos.r][blockPos.c] = null;
                        b.p = new Pos(r,blockPos.c);
                        blockPos = b.p;
                    } else if (board[r][blockPos.c].num == b.num) {
                        if (b.isMerged || board[r][blockPos.c].isMerged) break;
                        board[r][blockPos.c].num *= 2;
                        ans = Math.max(ans,board[r][blockPos.c].num);
                        board[r][blockPos.c].isMerged = true;
                        board[blockPos.r][blockPos.c] = null;
                        b.p = new Pos(r,blockPos.c);
                        break;
                    }
                }
            }
        }
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (board[i][j] != null)
                    board[i][j].isMerged = false;
            }
        }
    }

    public static Block[][] getBackup() {
        Block[][] backup = new Block[n+1][n+1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (board[i][j] != null) {
                    backup[i][j] = board[i][j].copy();
                }
            }
        }
        return backup;
    }

    public static void dfs(int loop) {
        if (loop > 5) return;
        Block[][] backup = getBackup();
        for (Dir d : dirs) {
            moveOrMerge(d);
            dfs(loop+1);
            board = backup;
        }
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new Block[n+1][n+1];
        for (int i=1;i<=n;i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j=1;j<=n;j++) {
                int num = Integer.parseInt(tokenizer.nextToken());
                if (num != 0) {
                    board[i][j] = new Block(num,false,new Pos(i,j));
                }
            }
        }
        dfs(1);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
