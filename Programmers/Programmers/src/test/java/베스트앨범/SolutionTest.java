package 베스트앨범;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        int[] res = sol.solution(new String[]{"classic","pop","classic","classic","pop"},new int[]{500,600,150,800,2500});
        int[] expected = new int[]{4,1,3,0};
        Assert.assertEquals(4,res.length);
        for (int i=0;i<4;i++) {
            Assert.assertEquals(expected[i],res[i]);
        }
    }
}
