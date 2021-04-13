package 네트워크;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(2,sol.solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        Assert.assertEquals(1,sol.solution(3,new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }
}
