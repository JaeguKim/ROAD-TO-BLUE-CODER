package Lotto;

import java.io.*;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int[] number, int d, int index, int[] ans) throws IOException {
        if (d == 6) {
            for (int i=0;i<6;i++){
                if (i==5) bw.write(ans[i]+"\n");
                else bw.write(ans[i]+" ");
            }
            return;
        }
        for (int i=index;i<number.length;i++){
            ans[d] = number[i];
            dfs(number,d+1,i+1,ans);
        }
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (!(input = br.readLine()).equals("0")) {
            String[] ary = input.split(" ");
            int k = Integer.parseInt(ary[0]);
            int[] number = new int[k];
            for (int i=0;i<k;i++) {
                number[i]=Integer.parseInt(ary[i+1]);
            }
            dfs(number,0,0,new int[6]);
            bw.newLine();
            bw.flush();
        }
    }
}
