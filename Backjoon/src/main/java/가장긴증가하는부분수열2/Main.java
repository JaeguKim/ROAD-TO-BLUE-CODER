package 가장긴증가하는부분수열2;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(Integer.MIN_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0) {
            int num = Integer.parseInt(st.nextToken());
            if (treeSet.last() >= num) {
                treeSet.remove(treeSet.ceiling(num));
            }
            treeSet.add(num);
        }
        return treeSet.size()-1;
    }

    public static void main(String[] args) throws IOException {
        int res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
