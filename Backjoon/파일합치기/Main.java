import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// t
// k (3~500)
// size of each chapter
// output - minimum cost for merging files
// dp[i][j] = min(dp[i][m]+dp[m+1][j] for m in )
// size_dp[i][j] = 최소가 되는 해당 size_dp+cost[j]
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int[] size = new int[k];
            for (int i = 0; i < k; i++) {
                size[i] = Integer.parseInt(tokenizer.nextToken());
            }
            int[][] dp = new int[k][k];
            int[][] size_dp = new int[k][k];
            for (int offset = 0; offset < k; offset++) {
                for (int r = 0; r < k - offset; r++) {
                    int c = r + offset;
                    if (r == c){
                        size_dp[r][c] = size[r];
                    }
                    else {
                        int minVal = Integer.MAX_VALUE;
                        for (int m = r; m < c; m++) {
                            if (minVal > dp[r][m] + dp[m + 1][c]+ size_dp[r][m] + size_dp[m+1][c]){
                                minVal = dp[r][m] + dp[m + 1][c]+ size_dp[r][m] + size_dp[m+1][c];
                                size_dp[r][c] = size_dp[r][m] + size_dp[m+1][c];
                            }
                        }
                        dp[r][c] = minVal;
                    }
                }
            }
            bw.write(dp[0][k - 1] + "\n");
            bw.flush();
        }
    }
}
