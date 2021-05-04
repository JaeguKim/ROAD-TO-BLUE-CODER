package 등굣길;

class Solution {

    int MOD = 1000000007;

    class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean checkBound(int n, int m) {
            return (r >= 1 && r <= n && c >= 1 && c <= m);
        }
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        dp[1][1] = 1;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++) {
                if (dp[i][j] == -1 || (i == 1 && j == 1)) continue;
                Pos left = new Pos(i,j-1);
                Pos up = new Pos(i-1,j);
                int cnt = 0;
                if (left.checkBound(n,m) && dp[left.r][left.c] != -1) {
                    cnt += dp[left.r][left.c]%MOD;
                }
                if (up.checkBound(n,m) && dp[up.r][up.c] != -1) {
                    cnt += dp[up.r][up.c]%MOD;
                }
                dp[i][j] = cnt%MOD;
            }
        }
        return dp[n][m];
    }
}