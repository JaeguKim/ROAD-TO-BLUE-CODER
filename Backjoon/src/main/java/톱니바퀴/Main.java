package 톱니바퀴;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String[] wheels = new String[5];
    static Set<Integer> visited;
    static int[][] score = new int[][]{{0,0},{0,1},{0,2},{0,4},{0,8}};

    public static void dfs(int num, int dir) {
        if (visited.contains(num)) return;
        String curWheel = wheels[num];
        String right = null;
        String left = null;
        visited.add(num);
        if (num + 1 <= 4) right = wheels[num+1];
        if (num - 1 >= 1) left = wheels[num-1];
        if (right != null) {
            if (curWheel.charAt(2) != right.charAt(6)) {
                dfs(num+1,dir*(-1));
            }
        }
        if (left != null) {
            if (curWheel.charAt(6) != left.charAt(2)) {
                dfs(num-1,dir*(-1));
            }
        }
        if (dir == 1) {
            wheels[num] = curWheel.charAt(curWheel.length()-1)+curWheel.substring(0,curWheel.length()-1);
        }
        else if (dir == -1) {
            wheels[num] = curWheel.substring(1)+curWheel.charAt(0);
        }
        visited.remove(num);
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0;i<4;i++) {
            wheels[i+1] = br.readLine();
        }
        visited = new HashSet<>();
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int dir = Integer.parseInt(input[1]);
            dfs(num,dir);
        }
        int ans = 0;
        for (int i=1;i<=4;i++) {
            ans += score[i][wheels[i].charAt(0)-'0'];
        }
        return ans;
    }

//2,6
    public static void main(String[] args) throws IOException {
        int res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
