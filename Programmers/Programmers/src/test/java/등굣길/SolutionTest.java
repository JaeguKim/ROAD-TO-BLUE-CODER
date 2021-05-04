package 등굣길;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(4,sol.solution(4,3,new int[][]{{2,2}}));
    }
}
