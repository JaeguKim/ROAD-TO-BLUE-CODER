package 하노이의탑;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class MoveInfo {
        int from;
        int to;
        public MoveInfo(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    List<MoveInfo> ans = new ArrayList<>();

    public void solve(int n, int from, int middle, int to) {
        if (n == 0) return;
        solve(n-1,from,to,middle);
        ans.add(new MoveInfo(from,to));
        solve(n-1,middle,from,to);
    }

    public int[][] solution(int n) {
        solve(n,1,2, 3);
        int[][] answer = new int[ans.size()][2];
        for (int i=0;i<ans.size();i++) {
            answer[i][0] = ans.get(i).from;
            answer[i][1] = ans.get(i).to;
        }
        return answer;
    }
}
