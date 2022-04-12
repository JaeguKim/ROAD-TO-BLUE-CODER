package prob289;

public class Solution {
    private boolean checkBound(int W, int H, int r, int c) {
        return (0 <= r && r < H) && (0 <= c && c < W);
    }

    public void gameOfLife(int[][] board) {
        int W = board[0].length, H = board.length;
        int[][] newBoard = new int[H][W];
        int[] dx = {0,1,1,1,0,-1,-1,-1};
        int[] dy = {1,1,0,-1,-1,-1,0,1};
        for (int i=0; i<H; ++i) {
            for (int j=0; j<W; ++j) {
                int cnt = 0;
                for (int k=0; k<8; ++k) {
                    int newR = i+dx[k];
                    int newC = j+dy[k];
                    if (checkBound(W,H,newR,newC) && board[newR][newC] == 1) {
                        cnt++;
                    }
                }
                newBoard[i][j] = board[i][j];
                if (board[i][j] == 1) {
                    if (cnt < 2) newBoard[i][j] = 0;
                    else if (cnt > 3) newBoard[i][j] = 0;
                } else if (cnt == 3) newBoard[i][j] = 1;
            }
        }
        for (int i=0; i<H; ++i) {
            board[i] = newBoard[i].clone();
        }
    }

    public static void main(String[] args) {
        int[][] board = {{1,1},{1,0}};
        Solution sol = new Solution();
        sol.gameOfLife(board);

    }
}
