import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//input
//n k
//output
// return ans % 1,000,000,000 

// dp[201][201], dp[i][j]
// i : sum, j : count
// dp[i][j] = dp[i-1][j]+dp[i][j-1]
// loop each k, for m 0...n, if m == 0: dp[m][k-1] = 1

public class Main {

    static int MAX = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[][] dp = new int[201][201];
        dp[n][1] = 1;
        for (int cnt=2; cnt<=k; cnt++){
            int accumSum = 0;
            for (int sum=0; sum<=n; sum++){
                if (sum == 0) dp[sum][cnt-1] = 1;
                else {
                    dp[sum][cnt-1] = dp[sum-1][cnt-1]%MAX+dp[sum][cnt-2]%MAX;
                }
                accumSum += dp[sum][cnt-1]%MAX;
                accumSum %= MAX;
            }
            dp[n][cnt] = accumSum;
        }
        bw.write(dp[n][k]+"\n");
        bw.flush();
    }
}
