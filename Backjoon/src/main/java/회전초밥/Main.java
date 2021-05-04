package 회전초밥;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static Set<Integer> set;
    static Deque<Integer> deq;
    static int c;
    static int[] cnt;

    public static int getDiffCnt() {
        int ans = 0;
        if (cnt[c] == 0) {
            ans = set.size()+1;
        }
        else {
            ans = set.size();
        }
        return ans;
    }

    public static int solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt = new int[d+1];
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }
        set = new HashSet<>();
        deq = new ArrayDeque<>();
        int ans = 0;
        for (int i=0;i<k;i++) {
            deq.addLast(list.get(i));
            set.add(list.get(i));
            cnt[list.get(i)]++;
        }
        ans = getDiffCnt();
        for (int i=1;i<list.size();i++) {
            int front = deq.removeFirst();
            cnt[front]--;
            if (cnt[front] == 0) {
                set.remove(front);
            }
            int lastIdx = (i+k-1)%N;
            int last = list.get(lastIdx);
            deq.addLast(last);
            set.add(last);
            cnt[last]++;
            ans = Math.max(ans,getDiffCnt());
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
