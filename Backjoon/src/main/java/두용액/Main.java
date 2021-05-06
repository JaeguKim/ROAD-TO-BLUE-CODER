package 두용액;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] ans = new int[2];
    static int closestSum;

    public static String solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeSet<Integer> treeSet = new TreeSet<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        treeSet.add(Integer.parseInt(st.nextToken()));
        treeSet.add(Integer.parseInt(st.nextToken()));
        ans[0] = treeSet.first();
        ans[1] = treeSet.last();
        closestSum = Math.abs(ans[0]+ans[1]);
        n-=2;
        while (n-->0) {
            int num = Integer.parseInt(st.nextToken());
            Integer[] cases = new Integer[4];
            cases[0] = treeSet.ceiling(num);
            cases[1] = treeSet.ceiling(num*-1);
            cases[2] = treeSet.floor(num);
            cases[3] = treeSet.floor(num*-1);
            int[] costs = new int[4];
            Arrays.fill(costs,Integer.MAX_VALUE);
            for (int i=0;i<4;i++) {
                if (cases[i] != null) {
                    costs[i] = Math.abs(cases[i]+num);
                }
            }
            int minCase = Math.min(Math.min(costs[0],costs[1]),Math.min(costs[2],costs[3]));
            if (closestSum > minCase) {
                closestSum = minCase;
                for (int i=0;i<4;i++) {
                    if (closestSum == costs[i]) {
                        ans[0]=num;
                        ans[1]=cases[i];
                    }
                }
             }
            treeSet.add(num);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.min(ans[0],ans[1])+" "+Math.max(ans[0],ans[1]));
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
