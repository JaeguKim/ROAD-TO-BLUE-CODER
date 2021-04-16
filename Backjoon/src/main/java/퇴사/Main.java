package 퇴사;

import java.io.*;

public class Main {

    static int max = 0;
    static int n;
    static int[] T;
    static int[] P;

    public static void bruteForce(int day, int gain) {
        if (day > n) return;
        if (day+T[day-1]-1 <= n) {
            max = Math.max(max,gain+P[day-1]);
        }
        bruteForce(day+T[day-1],gain+P[day-1]);
        bruteForce(day+1,gain);
    }

    public static int solution(int _n, int[] _T, int[] _P) {
        max = 0;
        n = _n;
        T = _T;
        P = _P;
        bruteForce(1,0);
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        T = new int[n];
        P = new int[n];
        for (int i=0;i<n;i++) {
            String[] ary = br.readLine().split(" ");
            T[i] = Integer.parseInt(ary[0]);
            P[i] = Integer.parseInt(ary[1]);
        }
        bw.write(solution(n,T,P)+"\n");
        bw.flush();
    }
}
