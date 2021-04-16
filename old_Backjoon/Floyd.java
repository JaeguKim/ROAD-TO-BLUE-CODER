import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Floyd {

    private static int n,e;
    private static int MAX = 10000001;
    private static int[][] distance;

    public static void runFloyd() {
        for (int k=0; k< n; k++){
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    distance[i][j] = Math.min(distance[i][j],distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        distance = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i == j) distance[i][j] = 0;
                else distance[i][j] = MAX;
            }
        }

        for (int i=0; i<e; i++){
            String[] input = br.readLine().split(" ");
            int startIdx = Integer.parseInt(input[0]);
            int endIdx = Integer.parseInt(input[1]);
            int inputCost = Integer.parseInt(input[2]);
            distance[startIdx-1][endIdx-1] = Math.min(distance[startIdx-1][endIdx-1],inputCost);
        }

        runFloyd();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int val = distance[i][j] < MAX ? distance[i][j] : 0;
                bw.write(val+" ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}