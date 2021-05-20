package 거스름돈;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution sol = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(4,sol.solution(5, new int[]{1, 2, 5}));
    }
}
