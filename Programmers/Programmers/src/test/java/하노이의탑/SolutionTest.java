package 하노이의탑;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        int[][] ans = sol.solution(2);
        int[][] expected = new int[][]{{1,2},{1,3},{2,3}};
        Assert.assertEquals(expected.length,ans.length);
        for (int i=0;i<ans.length;i++) {
            Assert.assertTrue(ans[i][0] == expected[i][0] && ans[i][1] == expected[i][1]);
        }
    }
}
