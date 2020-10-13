import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 임의의 행 i에서 임의의 수 x 보다 작거나 같은수의 갯수
// i*j <= x , min(x/i,n)
// n이 (1~10^5) 중에서 작거나 같은수의 갯수가 K 개가 되는 수를 찾아라
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long left = 1;
        long right = k;
        long ans = 0;
        while (left <= right){
            long cnt = 0;
            long mid = (left+right)/2;
            for (int i=1;i<=n;i++){
                cnt += Math.min(mid/i,n);
                if (cnt > k) break;
            }
            if (cnt < k){
            left = mid+1;
            }
            else {
                right = mid-1;
                ans = mid;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
     }
}
