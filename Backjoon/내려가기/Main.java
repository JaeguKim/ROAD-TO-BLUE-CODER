import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// maxDp,minDp 선언
// 첫째 줄에는 값을 그대로 복사, 최대.최소 업데이트하기
// 둘째 줄부터는 LU,U,RU + 현재값 중 최대값을 저장, 최대.최소 업데이트
// 리턴
// Time : O(N), Space : O(N) ~= 4MB, 사실 O(1)으로 풀수도 있다
public class Main {

    static int n;
    
    public static boolean checkBound(int r, int c){
        if (r < 0 || r > n-1 || c < 0 || c > 2){
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];
        int[][] offsets = {{-1,-1},{-1,0},{-1,1}};
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(tokenizer.nextToken());
                if (i == 0) {
                    maxDp[i][j] = num;
                    minDp[i][j] = num;
                }
                else {
                    int maxVal = Integer.MIN_VALUE;
                    int minVal = Integer.MAX_VALUE;
                    for (int[] offset : offsets){
                        int r = i+offset[0];
                        int c = j+offset[1];
                        if (checkBound(r,c)){
                            maxVal = Math.max(maxVal,maxDp[r][c]+num);
                            minVal = Math.min(minVal,minDp[r][c]+num);
                        }
                    }
                    maxDp[i][j] = maxVal;
                    minDp[i][j] = minVal;
                }                
            }
        }
        int globalMax = Arrays.stream(maxDp[n-1]).max().getAsInt();
        int globalMin = Arrays.stream(minDp[n-1]).min().getAsInt();
        bw.write(String.format("%d %d\n",globalMax,globalMin));
        bw.flush();
    }
}
