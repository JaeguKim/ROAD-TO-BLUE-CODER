package 영으로만들기;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(9,sol.solution(new int[]{-5,0,2,1,2},new int[][]{{0,1},{3,4},{2,3},{0,3}}));
        Assert.assertEquals(-1,sol.solution(new int[]{0,1,0},new int[][]{{0,1},{1,2}}));

    }
}
