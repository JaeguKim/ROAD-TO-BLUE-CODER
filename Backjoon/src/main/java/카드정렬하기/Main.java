package 카드정렬하기;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- >0) {
            que.add(Integer.parseInt(br.readLine()));
        }
        int ans = 0;
        while (que.size()>1) {
            int mergedSize = que.poll()+que.poll();
            ans += mergedSize;
            que.add(mergedSize);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
