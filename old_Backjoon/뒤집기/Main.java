    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.OutputStreamWriter;
    import java.util.StringTokenizer;

    public class Main {

        static int divisor = 1000000007;

        static int pow(int a, int b) {
            int res = 1;
            for (int i = 0; i < b; i++) {
                res *= a;
                res %= divisor;
            }
            return res;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            char[][] map = new char[n][m];
            for (int i=0; i<n; i++){
                tokenizer = new StringTokenizer(br.readLine());
                String line = tokenizer.nextToken();
                for (int j=0; j<m; j++){
                    map[i][j] = line.charAt(j);
                }
            }
            int[][] offset = {{0,1},{0,-1},{1,0},{-1,0}};
            int cnt = 0;
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    char ch = map[i][j];
                    boolean flag = true;
                    for (int k=0; k<4; k++){
                        int newR = i+offset[k][0];
                        int newC = j+offset[k][1];
                        if (newR >= 0 && newR < n && newC >= 0 && newC < m){
                            if (map[newR][newC] != ch){
                                flag = false;
                            }    
                        }
                    }
                    if (flag) cnt++;
                }
            }
            bw.write(pow(2,cnt)+"\n");
            bw.flush();
        }
    }
